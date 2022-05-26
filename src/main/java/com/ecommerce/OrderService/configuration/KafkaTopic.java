package com.ecommerce.OrderService.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("producttechie11")
                .build();
    }

}
