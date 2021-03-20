package com.imranscode.graphql.graphqldemo.orders;

import com.imranscode.graphql.graphqldemo.customers.Customer;
import com.imranscode.graphql.graphqldemo.products.Product;

import java.time.LocalDate;

public class Order {
    private Long id;

    private Customer customer;

    private Product product;

    private Integer quantity;

    private String status;

    private LocalDate created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


