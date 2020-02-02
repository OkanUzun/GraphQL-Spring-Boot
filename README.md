**A simple graphQL application with Spring Boot**

**Instructions**

1) run ./mvnw clean install

2) run ./mvnw spring-boot:run

3) go to http://localhost:8080/graphiql

create product
    
    mutation {
      createProduct(code: "x", name: "product x", maxSellableQuantity: 8, price: 16.5) {
        id
        code
        name
        maxSellableQuantity
        price
      }
    }    
    
get products with count

    {
      products(count: 10) {
        code
        id
        code
        name
        maxSellableQuantity
      }
    }
    
get product by id

    query{
      product(id : 1){
        id
        code
        maxSellableQuantity
      }
    }    
    
    






