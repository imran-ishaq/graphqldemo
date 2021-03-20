package com.imranscode.graphql.graphqldemo.customers;

import com.imranscode.graphql.graphqldemo.customers.data.CustomerModel;
import com.imranscode.graphql.graphqldemo.customers.data.CustomerRepository;
import com.imranscode.graphql.graphqldemo.orders.CreateOrderInput;
import com.imranscode.graphql.graphqldemo.orders.Order;
import com.imranscode.graphql.graphqldemo.orders.data.OrderModel;
import com.imranscode.graphql.graphqldemo.orders.data.OrderRepository;
import com.imranscode.graphql.graphqldemo.products.Product;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {

    private CustomerRepository customerRepository;


    public Customer createCustomer(CreateCustomerInput createCustomerInput) {
        CustomerModel customer = new CustomerModel();
        customer.setId(createCustomerInput.getId());
       customer.setEmail(createCustomerInput.getEmail());
       customer.setName(createCustomerInput.getName());
       customerRepository.save(customer);
        return customerToGraphQL(customer);
    }

    private Customer customerToGraphQL(CustomerModel customerModel) {
       Customer cus =new Customer();
        cus.setId(customerModel.getId());
        cus.setEmail(customerModel.getEmail());
        cus.setName(customerModel.getName());


        return cus;
    }

}