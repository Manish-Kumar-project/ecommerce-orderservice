package com.ecommerce.OrderService.service;

import com.ecommerce.OrderService.commons.OrderRequest;
import com.ecommerce.OrderService.commons.OrderResponse;
import com.ecommerce.OrderService.commons.Product;
import com.ecommerce.OrderService.communication.OrderServiceFeignClient;
import com.ecommerce.OrderService.entities.OrderItem;
import com.ecommerce.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private OrderServiceFeignClient orderServiceFeignClient;

    public OrderResponse addOrder(OrderRequest request){
//        OrderItem saveOrder = orderRepository.save(order);
//        return saveOrder;
        String response = "";
        OrderItem order = request.getOrder();
        Product payment = request.getProduct();
        payment.setOrderId(order.getId());
        payment.setOrderAmount(order.getOrderAmount());
        //rest call
        //logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(request));
        //Payment paymentResponse = template.postForObject(ENDPOINT_URL, payment, Payment.class);
        //Product productResponse = template.postForObject("http://PRODUCT-SERVICE/api/product/product",payment,Product.class);
        Product productResponse = orderServiceFeignClient.getProduct(payment);
        response = productResponse.getProductStatus().equals("success")?"product processing sucessful and orderplaced":"There is a failure in order Api and order added to the cart";
        orderRepository.save(order);
        return new OrderResponse(order,productResponse.getOrderAmount(),response);

    }

    public List<OrderItem> getAllOrders(){
        List<OrderItem> listOfOrders = orderRepository.findAll();
        return listOfOrders;
    }

}
