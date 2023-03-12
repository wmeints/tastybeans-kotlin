package com.tastybeans.services.profile

import com.rabbitmq.client.Channel
import org.axonframework.extensions.amqp.eventhandling.AMQPMessageConverter
import org.axonframework.extensions.amqp.eventhandling.spring.SpringAMQPMessageSource
import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfiguration {
    @Bean
    fun queue(): Queue {
        return Queue("profile")
    }

    @Bean
    fun queueMessageSource(messageConverter: AMQPMessageConverter): SpringAMQPMessageSource {
        return object: SpringAMQPMessageSource(messageConverter) {
            @RabbitListener(queues = ["profile"])
            override fun onMessage(message: Message?, channel: Channel?) {
                super.onMessage(message, channel)
            }
        }
    }
}