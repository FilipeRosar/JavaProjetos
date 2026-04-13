package com.desafio.btg.service;


import com.desafio.btg.entity.OrderEntity;
import com.desafio.btg.entity.OrderItem;
import com.desafio.btg.listener.dto.OrderCreatedEvent;
import com.desafio.btg.repository.OrderRepositotry;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepositotry _orderRepositotry;

    public OrderService(OrderRepositotry _orderRepositotry) {
        this._orderRepositotry = _orderRepositotry;
    }

    public void save(OrderCreatedEvent event) {

        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));

        _orderRepositotry.save(entity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.items()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.items().stream()
                .map(i -> new OrderItem(i.produto(),i.quantidade(),i.preco()))
                .toList();
    }
}
