package com.imranscode.graphql.graphqldemo.customers.data;

import com.imranscode.graphql.graphqldemo.customers.data.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

}
