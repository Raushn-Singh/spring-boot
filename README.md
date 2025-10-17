# Spring Boot and Dependency Injection Examples

This Markdown file contains **all the Spring Boot examples** you provided, demonstrating **Dependency Injection (DI)**, **Bean creation**, and **Spring annotations**. Explanations are included for beginners.

---

## Basic Terminology

* **Spring Boot**: Framework to create stand-alone, production-grade Spring applications easily.
* **Bean**: An object managed by the Spring container.
* **@Component**: Marks a class as a Spring-managed component.
* **@Autowired**: Automatic dependency injection.
* **@Bean**: Method-level annotation for bean creation in configuration classes.
* **@Configuration**: Marks a class as a source of bean definitions.
* **@Qualifier**: Selects a specific bean when multiple beans of the same type exist.
* **@Primary**: Marks a bean as the default when multiple candidates exist.
* **Field Injection**: Injecting dependencies directly into fields.
* **Setter Injection**: Injecting dependencies via setter methods.
* **Constructor Injection**: Injecting dependencies via constructors.

---

## 1. `Order` Class in `com.training.app`

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

**Explanation:** Field injection is used to inject `Product`. When Spring creates `Order`, it prints a message.

---

## 2. `SpringBootFirstApplication` in `com.training.lms`

```java
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

**Explanation:** Demonstrates Spring Boot main class, bean creation, and dependency injection.

---

## 3. `Product` Class in `com.training.lms.app`

```java
@Component
public class Product {
    public Product() {
        System.out.println("Product is Created");
    }
}
```

**Explanation:** Component class; Spring manages its lifecycle.

---

## 4. Java Configuration `SpringBeansConfiguration`

```java
@Configuration
public class SpringBeansConfiguration {

    @Bean
    public Product product1() {
        System.out.println("Product is created via bean Method");
        return new Product();
    }
}
```

**Explanation:** Shows Java-based bean creation via `@Configuration` and `@Bean`.

---

## 5. Delivery Examples

```java
public class DeliveryDetails {
    public DeliveryDetails() {
        System.out.println("DeliveryDetails is created......");
    }
}

public class SpringXMLWithBoot {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    }
}
```

**Explanation:** Demonstrates non-Spring managed class and XML-based Spring bean loading.

---

## 6. Field DI with `OrderDetails` and `CartItems`

```java
@Component("cartItems1")
public class CartItems {
    private int noOfItems;
    private ArrayList<String> itemNames;
    // getters, setters, constructors
}

@Component
public class OrderDetails {
    @Autowired
    private CartItems cartItems;
    private double orderAmount;
    private String userEmail;
    // getters, setters
}
```

**Explanation:** Shows field injection and multiple ways to define beans.

---

## 7. Food Delivery Example

```java
@Component
public class Product { /* properties, constructors, getters, setters */ }
@Component
public class Order { 
    @Autowired
    public void setProduct(@Qualifier("productTwo") Product product) {
        this.product = product;
    }
}
@Component
public class OrderDelivery {
    @Autowired
    private Order order;
}
@Configuration
public class SpringConfigurationBeans {
    @Bean("productTwo")
    public Product getProduct() { return new Product(); }
}
```

**Explanation:** Setter injection and configuration-based bean creation.

---

## 8. Constructor DI Example

```java
@Component
public class Order {
    public Order(@Autowired @Qualifier("productOne") Product product) {
        this.product = product;
    }
}
```

**Explanation:** Constructor injection allows injecting dependencies through constructor parameters.

---

## 9. Interface-based DI Example

```java
public interface Vehicle { String VehicleType(); }

@Primary
@Component
public class Car implements Vehicle { ... }
@Component
public class Bike implements Vehicle { ... }
@Component
public class Bus implements Vehicle { ... }

@Component
public class Garrage {
    @Autowired
    private Vehicle vehicle;
}
```

**Explanation:** Demonstrates interface injection and usage of `@Primary` for default bean selection.

---

## Key Takeaways for Beginners

1. **Spring manages objects:** Components and beans are automatically instantiated.
2. **Dependency Injection:** Avoid manual object creation; Spring injects dependencies.
3. **Bean Identification:** Use `@Qualifier` and `@Primary` to resolve conflicts.
4. **Different DI methods:** Field, setter, and constructor injections.
5. **Configuration flexibility:** Beans can be defined via annotations, Java configuration, or XML.

---

This Markdown file now contains **all your code and explanations** without modifying the original code structure.
