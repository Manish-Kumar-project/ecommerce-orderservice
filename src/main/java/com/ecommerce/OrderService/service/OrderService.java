package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.commons.OrderRequest;
import com.ecommerce.OrderService.commons.OrderResponse;
import com.ecommerce.OrderService.commons.PaymentTransaction;
import com.ecommerce.OrderService.commons.Product;
import com.ecommerce.OrderService.communication.OrderServiceFeignClient;
import com.ecommerce.OrderService.entities.OrderItem;
import com.ecommerce.OrderService.entities.OrderItems;
import com.ecommerce.OrderService.kafka.producer.ProductSenderEvent;
import com.ecommerce.OrderService.model.v1.ProductCatalogModel;
import com.ecommerce.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private OrderServiceFeignClient orderServiceFeignClient;

    @Autowired
    private ProductSenderEvent sender;

    public OrderResponse addOrder(OrderRequest request){
        String response = "";
        OrderItem order = request.getOrder();
        Product payment = request.getProduct();
        payment.setOrderId(order.getId());
        payment.setOrderAmount(order.getOrderAmount());
        Product productResponse = orderServiceFeignClient.getProduct(payment);
        response = productResponse.getProductStatus().equals("success")?"product processing sucessful and orderplaced":"There is a failure in order Api and order added to the cart";
        orderRepository.save(order);
        return new OrderResponse(order,productResponse.getOrderAmount(),response);
    }

    public List<OrderItem> getAllOrders(){
        List<OrderItem> listOfOrders = orderRepository.findAll();
        return listOfOrders;
    }

    private void sendMessageToKafka(ProductCatalogModel productCatalog) {
        sender.sendMessage(productCatalog);
    }

    public void saveMemberOrder(OrderItems order){
        Product product = new Product();
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setTransactionAmount(order.getOrderTotalPrice());
        paymentTransaction.setCardBrand(order.getCardBrand());
        paymentTransaction.setCardNumber(order.getCardNumber());
        paymentTransaction.setCardCvv(order.getCardCvv());
        paymentTransaction.setCardExpiry(order.getCardExpiry());
        paymentTransaction.setCardBrand(order.getCardBrand());
        paymentTransaction.setMemberId(order.getMemberId());
        paymentTransaction.setCardOwnerName(order.getCardOwnerName());
        paymentTransaction.setTransactionId(order.getProductUniqueid());
        paymentTransaction.setCardType(order.getCardType());

        String responseMessage = orderServiceFeignClient.savePaymentTransaction(paymentTransaction);
        if(responseMessage.equals("payment_successful")){
            ProductCatalogModel productCatalog = new ProductCatalogModel();
            productCatalog.setProductCatalogName(order.getProductName());
            productCatalog.setProductBrand(order.getProductBrand());
            productCatalog.setProductCatalogUniqueId(order.getProductUniqueid());
            productCatalog.setProductCatalogQuantity(order.getProductQuantity());
            sendMessageToKafka(productCatalog);
        }

    }

}
