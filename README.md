# Springboot-Starter-GraphQL
Getting Started with GraphQL and Spring Boot

#Overview of GraphQL Schema
Schema design is the first thing we would look at. GraphQL schema are typed meaning we need to specify the types and attributes of each type.

GraphQL type	Description
#Query	        
Is used for fetching information. Similar to GET method.
#Mutation	    
Is used for inserting, updating or deleting information. Similar to POST, PUT or PATCH methods in REST.
#Subscription	
Is used for streaming the information from server similar to Websocket
For this GraphQL Spring Boot tutorial, subscription will be out of scope. We will tackle that beast in another tutorial :-)

#GraphQL Schema SDL
The GraphQL schema can be written using GraphQL SDL (Schema Definition Language). Following is our app’s GraphQL schema.

Schema definition file is under src/resources directory. GraphQL Spring Boot starter will read this and configure it using graphql-java-tools.

src/resources/schema.graphqls

`type Query {
customerById(id: ID!): Customer
}

type Customer {
id: ID!
name: String!
email: String!
orders: [Order]
}

type Order {
id: ID!
customer: Customer!
product: Product!
quantity: Int!
status: String!
}

type Product {
id: ID!
name: String
description: String
price: String
}`

#Introspecting using GraphiQL
Once the Spring Boot app is started on default port 8080, open http://localhost:8080/graphiql

Try running following GraphQL query and see the output.
`query {
customerById(id: 1) {
name
orders {
id
status
product {
name
}
}
}
}`
To view Db Schema enter in browser http://localhost:8080/h2-console
