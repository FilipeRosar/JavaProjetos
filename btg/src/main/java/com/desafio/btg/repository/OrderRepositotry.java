package com.desafio.btg.repository;

import com.desafio.btg.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepositotry extends MongoRepository<OrderEntity, Long> {
}
