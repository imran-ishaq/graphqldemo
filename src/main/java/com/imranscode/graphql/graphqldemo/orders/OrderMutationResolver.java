package com.imranscode.graphql.graphqldemo.orders;

import com.imranscode.graphql.graphqldemo.customers.Customer;
import com.imranscode.graphql.graphqldemo.orders.data.OrderModel;
import com.imranscode.graphql.graphqldemo.orders.data.OrderRepository;
import com.imranscode.graphql.graphqldemo.products.Product;
import graphql.kickstart.tools.GraphQLMutationResolver;

import org.springframework.stereotype.Component;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {

    private OrderRepository orderRepository;

    public OrderMutationResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderInput createOrderInput) {
        OrderModel order = new OrderModel();

        order.setCustomerId(createOrderInput.getCustomerId());
        order.setProductId(createOrderInput.getProductId());
        order.setQuantity(createOrderInput.getQuantity());
        order.setStatus("PENDING");
        orderRepository.save(order);


        return orderToGraphQL(order);
    }

    private Order orderToGraphQL(OrderModel orderModel) {
        Order order = new Order();
        order.setId(orderModel.getId());
        order.setStatus(orderModel.getStatus());
        order.setQuantity(orderModel.getQuantity());
        order.setCreated(orderModel.getCreated());

        Product product = new Product();
        product.setId(orderModel.getProductId());
        order.setProduct(product);

        Customer customer = new Customer();
        customer.setId(orderModel.getCustomerId());
        order.setCustomer(customer);

        return order;
    }

}