package com.desafio.btg.listener;

import com.desafio.btg.service.OrderService;
import org.slf4j.Logger;
import com.desafio.btg.listener.dto.OrderCreatedEvent;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.desafio.btg.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

    private final Logger log = LoggerFactory.getLogger(OrderCreatedListener.class);

    private final OrderService _orderService;

    public OrderCreatedListener(OrderService orderService) {
        _orderService = orderService;
    }

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(OrderCreatedEvent event) {
        log.info("Message received : {}", event);

        _orderService.save(event);
    }
}
