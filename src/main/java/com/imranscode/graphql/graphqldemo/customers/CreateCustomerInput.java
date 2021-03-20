package com.imranscode.graphql.graphqldemo.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerInput {
    long id;
    String name;
    String email;
}
