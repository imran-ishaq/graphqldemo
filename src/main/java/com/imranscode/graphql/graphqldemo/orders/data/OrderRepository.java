package com.imranscode.graphql.graphqldemo.orders.data;

import com.imranscode.graphql.graphqldemo.orders.data.OrderModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    List<OrderModel> findByCustomerId(Long customerId);
}
