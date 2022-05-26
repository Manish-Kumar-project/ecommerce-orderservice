package com.ecommerce.OrderService.kafka.producer;

import com.ecommerce.OrderService.model.v1.ProductCatalogModel;
import com.ecommerce.OrderService.model.v1.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class ProductSenderEvent {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductSenderEvent.class);

    @Autowired
    private KafkaTemplate<String, Object> template;

    private String topic = "producttechie11";

    public void sendMessage(ProductCatalogModel productCatalogModel){
        publishMessage(productCatalogModel);
    }

    public String publishMessage(ProductCatalogModel productCatalogModel) {
        template.send(topic, productCatalogModel);
        return "Json Data published";
    }
}
