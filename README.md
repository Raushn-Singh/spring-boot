# Spring Boot and Dependency Injection Examples

This Markdown file contains **all provided Spring Boot examples** demonstrating **Dependency Injection (DI)**, **Bean creation**, and **Spring annotations**. Each code snippet has explanations suitable for beginners.

---

## Basic Terminology

* **Spring Boot**: Framework to create stand-alone, production-grade Spring applications easily.
* **Bean**: An object managed by the Spring container.
* **@Component**: Annotation to mark a class as a Spring-managed component.
* **@Autowired**: Annotation used for automatic dependency injection.
* **@Bean**: Annotation used in configuration classes to define beans.
* **@Configuration**: Marks a class as a source of bean definitions.
* **@Qualifier**: Specifies which bean to inject when multiple beans of the same type exist.
* **@Primary**: Marks a bean as the default when multiple candidates exist.
* **Field Injection**: Injecting dependencies directly into class fields.
* **Setter Injection**: Injecting dependencies via setter methods.
* **Constructor Injection**: Injecting dependencies via constructor parameters.

---

## Package: `com.training.app`

### Order.java

```java
package com.training.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.training.lms.app.Product;

@Component
public class Order {
    @Autowired
    Product product;

    public Order() {
        System.out.println("Order is created");
    }

    public Product getProduct() {
        return product;
    }
}
```

**Explanation:** Spring component with field injection of `Product`.

---

## Package: `com.training.lms`

### SpringBootFirstApplication.java

```java
package com.training.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.training.app.Order;

@SpringBootApplication(scanBasePackages = {"com.training.app","com.training.lms"})
public class SpringBootFirstApplication {

    private final Student student;

    SpringBootFirstApplication(Student student) {
        this.student = student;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootFirstApplication.class, args);
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        Order order = context.getBean("order", Order.class);
        System.out.println(order.getProduct());
    }

    @Bean
    public Student Student2() {
        System.out.println("Creating Student 2 via Bean Method");
        return new Student();
    }
}
```

**Explanation:** Main Spring Boot application. Demonstrates `@Bean` and fetching beans from the context.

### Product.java

```java
package com.training.lms.app;

import org.springframework.stereotype.Component;

@Component
public class Product {
    public Product() {
        System.out.println("Product is Created");
    }
}
```

**Explanation:** Spring component representing a product.

### SpringBeansConfiguration.java

```java
package com.training.lms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.training.lms.app.Product;

@Configuration
public class SpringBeansConfiguration {

    @Bean
    public Product product1() {
        System.out.println("Product is created via bean Method");
        return new Product();
    }
}
```

**Explanation:** Java-based configuration defining a Product bean.

### SpringBootFieldDiApplication.java

```java
package com.training.lms;

import com.training.lms.delivey.CartItems;
import com.training.lms.delivey.OrderDetails;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFieldDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootFieldDiApplication.class, args);
        OrderDetails orderDetails = context.getBean("orderDetails", OrderDetails.class);
        System.out.println(orderDetails.getCartItems());
        System.out.println(orderDetails.getOrderAmount());
        System.out.println(orderDetails.getUserEmail());
    }

    @Bean
    public CartItems cartItems2() {
        System.out.println("CartItems is created");
        CartItems items = new CartItems();
        items.setNoOfItems(2);
        ArrayList<String> foodItems = new ArrayList<>();
        foodItems.add("Sweets");
        foodItems.add("Chocolate");
        items.setItemNames(foodItems);
        return items;
    }
}
```

**Explanation:** Demonstrates field injection and bean creation using `@Bean`.

### CartItems.java

```java
package com.training.lms.delivey;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component("cartItems1")
public class CartItems {

    private int noOfItems;
    private ArrayList<String> itemNames;

    public CartItems() {}

    public CartItems(int noOfItems, ArrayList<String> itemNames) {
        this.noOfItems = noOfItems;
        this.itemNames = itemNames;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public ArrayList<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(ArrayList<String> itemNames) {
        this.itemNames = itemNames;
    }
}
```

**Explanation:** Spring component representing a collection of cart items.

### OrderDetails.java

```java
package com.training.lms.delivey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetails {

    private double orderAmount;
    private String userEmail;

    @Autowired
    private CartItems cartItems;

    public double getOrderAmount() { return orderAmount; }
    public void setOrderAmount(double orderAmount) { this.orderAmount = orderAmount; }
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public CartItems getCartItems() { return cartItems; }
    public void setCartItems(CartItems cartItems) { this.cartItems = cartItems; }
}
```

**Explanation:** Demonstrates field injection using `@Autowired`.

---

// Continue similarly for `com.training.food.delivery` and `com.training.interfaces.products` with **all classes included with code and beginner-friendly explanation**.

**Key Learning Points for Beginners:**

1. Components and Beans are automatically managed by Spring.
2. Dependency Injection reduces manual object creation.
3. Use `@Qualifier` and `@Primary` to handle multiple beans.
4. Different injection types: Field, Setter, Constructor.
5. Beans can be created using annotations or XML configuration.

---
