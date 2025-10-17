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

# Spring Boot Configuration Example – Complete Explanation

This project demonstrates **Spring Boot's configuration and dependency injection** using `@Value`, `@Autowired`, and `@PropertySource` annotations. It loads configuration values from external property files and injects them into beans.

---

## 🧩 1. Application Entry Point – `Application.java`

```java
package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.training.springboot.beans.AwsDatabaseConfiguration;
import com.training.springboot.beans.DatabaseCofiguration;
import com.training.springboot.beans.EmailsCrdentialsConfiguration;
import com.training.springboot.beans.org.OrganizationInfo;

@PropertySource("aws-database.properties") // Loads additional property file
@SpringBootApplication // Enables Spring Boot auto-configuration and component scanning
public class Application {
	public static void main(String[] args) {
		// Starts the Spring Boot application and returns the application context
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Fetching Database configuration bean
		DatabaseCofiguration cofiguration = context.getBean("databaseCofiguration", DatabaseCofiguration.class);
		System.out.println(cofiguration.getPort());
		System.out.println(cofiguration.getUrl());
		System.out.println(cofiguration.getUserName());
		System.out.println(cofiguration.getPassword());
		System.out.println(cofiguration.getAppName());
		System.out.println(cofiguration.getDbProfile().getUrl());

		// Fetching Email configuration bean
		System.out.println("******* Email Data ****");
		EmailsCrdentialsConfiguration emailConfig = context.getBean("emailsCrdentialsConfiguration", EmailsCrdentialsConfiguration.class);
		System.out.println(emailConfig.getEmailHost());
		System.out.println(emailConfig.getEmailId());
		System.out.println(emailConfig.getPassword());

		// Fetching Organization Info bean
		System.out.println("***** Org Data ******");
		OrganizationInfo info = context.getBean("organizationInfo", OrganizationInfo.class);
		System.out.println(info.getOrgEmpCount());
		info.getDeptNames().forEach(System.out::println);

		// Fetching AWS Database Configuration bean
		System.out.println("******************************");
		AwsDatabaseConfiguration awsConfig = context.getBean("awsDatabaseConfiguration", AwsDatabaseConfiguration.class);
		System.out.println(awsConfig.getAwsUserName());
		System.out.println(awsConfig.getAwsPassword());
		System.out.println(awsConfig.getAwsHost());
	}
}
```

### 🔍 Explanation:

* **`@SpringBootApplication`**: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
* **`@PropertySource`**: Loads properties from an external file (e.g., `aws-database.properties`).
* **`ConfigurableApplicationContext`**: Used to access beans created by Spring.

---

## ⚙️ 2. AWS Database Configuration – `AwsDatabaseConfiguration.java`

```java
package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AwsDatabaseConfiguration {
    @Value("${aws.db.url}")
    private String awsHost;

    @Value("${aws.db.user.name}")
    private String awsUserName;

    @Value("${aws.db.password}")
    private String awsPassword;

    // Getters and Setters
}
```

### 🔍 Explanation:

* Injects AWS database details from the property file.
* Uses **`@Value`** to bind property keys to Java fields.

Example in `aws-database.properties`:

```properties
aws.db.url=aws.amazonserver.com
aws.db.user.name=aws_user
aws.db.password=aws_pass
```

---

## 🗄️ 3. Local Database Configuration – `DatabaseCofiguration.java`

```java
package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCofiguration {
    @Value("${db.port.number}")
    private int port;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private DbProfile dbProfile; // Injects another bean

    public DatabaseCofiguration() {
        System.out.println("Db is created...");
    }

    // Getters and Setters
}
```

### 🔍 Explanation:

* Demonstrates **field injection** using `@Value`.
* Uses **`@Autowired`** to inject another bean (`DbProfile`).
* Useful when multiple configuration sources exist.

Example in `application.properties`:

```properties
db.port.number=1521
db.url=localhost:1521:xe
db.username=root
db.password=root
spring.application.name=SpringBootConfigDemo
```

---

## 🧮 4. Database Profile Bean – `DbProfile.java`

```java
package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("production")
public class DbProfile {
   @Value("${db.url}")
   private String url;

   // Getter and Setter
}
```

### 🔍 Explanation:

* Defines a **profile-specific** database URL.
* `@Component("production")` gives a custom bean name.

---

## 📧 5. Email Credentials Configuration – `EmailsCrdentialsConfiguration.java`

```java
package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailsCrdentialsConfiguration {

    private String emailHost;

    @Value("${app.mail.user}")
    private String emailId;

    private String password;

    @Autowired
    private DatabaseCofiguration databaseCofiguration;

    public EmailsCrdentialsConfiguration(@Value("${app.mail.host}") String emailHost) {
        this.emailHost = emailHost;
    }

    @Value("${app.mail.password}")
    public void setPassword(String password) {
        System.out.println("setEmailPassword");
        this.password = password;
    }

    // Getters and Setters
}
```

### 🔍 Explanation:

* Shows **constructor injection**, **setter injection**, and **field injection**.
* Demonstrates multiple ways to inject values using `@Value`.

Example in `application.properties`:

```properties
app.mail.host=smtp.gmail.com
app.mail.user=test@gmail.com
app.mail.password=test123
```

---

## 🏢 6. Organization Info – `OrganizationInfo.java`

```java
package com.training.springboot.beans.org;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrganizationInfo {
    @Value("${org.emp.count:55}") // default value if key is missing
    private int orgEmpCount;

    @Value("${org.dept.names}")
    private List<String> deptNames;

    // Getters and Setters
}
```

### 🔍 Explanation:

* Injects **list values** directly from the property file.
* Uses **default value** `55` when key is not present.

Example in `application.properties`:

```properties
org.emp.count=120
org.dept.names=HR,Finance,IT,Sales
```

---

## 📘 Summary

| Concept                | Annotation Used             | Description                           |
| ---------------------- | --------------------------- | ------------------------------------- |
| External Configuration | `@Value`, `@PropertySource` | Injects property values into fields   |
| Bean Creation          | `@Component`                | Marks class as a Spring-managed bean  |
| Dependency Injection   | `@Autowired`                | Automatically injects dependent beans |
| Constructor Injection  | `@Value` in constructor     | Provides value at object creation     |
| Setter Injection       | `@Value` on setter          | Sets value using setter method        |
| Lists and Defaults     | `@Value` with default       | Handles multiple values and fallbacks |

---

✅ **This example is perfect for beginners** who want to learn how to use `@Value`, `@Autowired`, and property files in Spring Boot. It shows all major injection techniques in one practical example.

# Spring Boot Bean Scopes and Dependency Injection – Beginner Friendly Guide

This example demonstrates how **Spring Boot manages beans**, their **scopes**, and how **dependency injection (DI)** works using annotations like `@Autowired`, `@Bean`, `@Component`, and `@Scope`.

---

## 🧩 1. Application Entry Point – `Application.java`

```java
package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.springboot.beans.Order;
import com.training.springboot.beans.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Getting Product bean from container
		Product product = context.getBean("product", Product.class);
		System.out.println(product);

		// Again fetching same bean to check if it creates a new instance or not
		Product product2 = context.getBean("product", Product.class);
		System.out.println(product2);

		// Getting Order bean which has Product injected
		Order order = context.getBean("order", Order.class);
		System.out.println(order);
		System.out.println(order.getProduct());

		Order order1 = context.getBean("order", Order.class);
		System.out.println(order1);
		System.out.println(order1.getProduct());

		// DI : Is it created a new Product to inject in Order? → No (because singleton)

		System.out.println("*********************** 2nd Product **** ");
		Product product3 = context.getBean("product2", Product.class);
		System.out.println(product3);
	}

	// Creating another Product bean manually using @Bean
	@Bean
	Product product2() {
		return new Product();
	}
}
```

### 🔍 Explanation of Basic Terms:

* **Bean:** An object managed by Spring’s IoC container.
* **IoC (Inversion of Control):** Spring creates and manages objects for you.
* **DI (Dependency Injection):** Injecting one bean into another automatically (e.g., Product into Order).
* **ApplicationContext:** Spring container that holds and manages beans.

### 💡 Key Concepts:

* When a bean is requested with `context.getBean()`, Spring returns it from the container.
* If the bean scope is **singleton** (default), the same object reference is returned every time.
* If the scope is **prototype**, a new object is created on each request.

---

## 🏗️ 2. Order Bean – `Order.java`

```java
package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
	@Autowired
	private Product product; // Dependency Injection

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
```

### 🔍 Explanation:

* **`@Component`**: Marks the class as a Spring bean.
* **`@Autowired`**: Automatically injects a matching bean (here, `Product`) from the container.
* When Spring creates an `Order` bean, it automatically sets its `product` field.

---

## 📦 3. Product Bean – `Product.java`

```java
package com.training.springboot.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope(value = "prototype") // Uncomment to test prototype behavior
@Component
public class Product {
	private int productId;
	private String productName;
	private double price;

	public Product() {
		super();
		System.out.println("Product one is created");
	}

	// Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
```

### 🔍 Explanation:

* By default, beans in Spring are **singleton**.
* The `Product` constructor prints a message each time it is created — helping us see when new objects are made.
* Uncomment `@Scope("prototype")` to make a new Product each time it’s requested.

---

## 🧠 4. Understanding Bean Scopes

Spring provides **5 main bean scopes**:

| Scope                   | Description                                                            |
| ----------------------- | ---------------------------------------------------------------------- |
| **singleton** (default) | Only one instance per Spring container. Same object shared everywhere. |
| **prototype**           | A new bean instance is created each time it is requested.              |
| **request**             | One bean per HTTP request (used in web apps).                          |
| **session**             | One bean per HTTP session (used in web apps).                          |
| **application**         | One bean for the entire application lifecycle.                         |
| **webSocket**           | One bean per WebSocket session.                                        |

### Example:

```java
@Scope("singleton") // default scope
@Component
public class Product {}

@Scope("prototype")
@Component
public class Order {}
```

---

## ⚙️ 5. Bean Lifecycle (Simple View for Beginners)

When Spring manages a bean, it goes through **4 main phases**:

1. **Construction** – Bean object is created.
2. **Configuration** – Dependencies are injected (like `@Autowired`).
3. **Utilization** – Bean is used for business logic.
4. **Destruction** – Bean is destroyed when the container shuts down.

---

## ✅ Summary for Beginners

| Concept                       | Explanation                                             |
| ----------------------------- | ------------------------------------------------------- |
| **Bean**                      | Object managed by Spring container                      |
| **Scope**                     | Defines how many instances of the bean exist            |
| **DI (Dependency Injection)** | Injecting dependent beans automatically                 |
| **Singleton Scope**           | Only one bean instance for the entire app               |
| **Prototype Scope**           | Creates a new instance every time you request the bean  |
| **@Autowired**                | Automatically wires dependent beans                     |
| **@Bean**                     | Defines a bean method manually in a configuration class |

---

### 🧩 Tip:

If you see the same memory reference printed for two beans, it means **singleton scope** is active. Different references mean **prototype scope** is used.

---

This explanation helps beginners clearly understand how **Spring Boot creates and injects beans**, how **scopes affect object creation**, and how **the lifecycle of a bean** works in simple, real-world terms.
