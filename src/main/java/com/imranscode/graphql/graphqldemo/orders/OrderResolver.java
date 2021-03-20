package com.imranscode.graphql.graphqldemo.orders;

import com.imranscode.graphql.graphqldemo.customers.Customer;
import com.imranscode.graphql.graphqldemo.customers.data.CustomerModel;
import com.imranscode.graphql.graphqldemo.customers.data.CustomerRepository;
import com.imranscode.graphql.graphqldemo.orders.Order;
import com.imranscode.graphql.graphqldemo.products.Product;
import com.imranscode.graphql.graphqldemo.products.data.ProductModel;
import com.imranscode.graphql.graphqldemo.products.data.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;

import org.springframework.stereotype.Component;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    public OrderResolver(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public Customer customer(Order order) {
        return customerRepository.findById(order.getCustomer().getId())
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    public Product product(Order order) {
        return productRepository.findById(order.getProduct().getId())
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    private Product modelToGraphQL(ProductModel productModel) {
        Product product = new Product();
        product.setDescription(productModel.getDescription());
        product.setName(productModel.getName());
        product.setId(productModel.getId());
        product.setPrice(productModel.getPrice());
        return product;
    }

    private Customer modelToGraphQL(CustomerModel customerModel) {
        Customer customer = new Customer();
        customer.setEmail(customerModel.getEmail());
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        return customer;
    }

}
