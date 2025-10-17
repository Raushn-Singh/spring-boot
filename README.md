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

# 🌱 Spring Boot Bean Lifecycle and Scope (Beginner to Advanced)

## 🧩 1. Introduction

In **Spring Boot**, every object managed by the **Spring Container** is called a **Bean**.  
The container controls its **creation**, **initialization**, and **destruction** — this process is known as the **Bean Lifecycle**.

---

## 🚀 2. Project Overview

This example demonstrates:
- How beans are created and managed by Spring Boot
- The difference between annotations and configuration-based bean definitions
- How to handle initialization and destruction phases
- The difference between `singleton` and `prototype` scope

### Project Structure:
```
com.training.springboot
 ├── Application.java
 └── databse
      ├── DatabaseConnection.java
      ├── EmailConnection.java
      └── SprinBeansConfiguration.java
```

---

## 🏁 3. Application Entry Point — `Application.java`

```java
package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.databse.DatabaseConnection;
import com.training.springboot.databse.EmailConnection;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		// Retrieving beans from container
		DatabaseConnection databaseConnection = context.getBean("databaseConnection", DatabaseConnection.class);
		System.out.println(databaseConnection);
		
		DatabaseConnection databaseConnection2 = context.getBean("databaseConnection", DatabaseConnection.class);
		System.out.println(databaseConnection2);
		
		EmailConnection emailConnection = context.getBean("emailConnection", EmailConnection.class);
		System.out.println(emailConnection);
		
		EmailConnection emailConnection2 = context.getBean("emailConnection2", EmailConnection.class);
		System.out.println(emailConnection2);
	}
}
```

### 🧠 Explanation:
- `@SpringBootApplication`: Marks the main class as the Spring Boot entry point.
- `SpringApplication.run(...)`: Starts the application and initializes the Spring context.
- `context.getBean(...)`: Fetches a bean managed by the Spring container.

**Output shows:**  
👉 Singleton beans return the same object reference.  
👉 Prototype beans return different object references.

---

## 🗄️ 4. Database Bean — `DatabaseConnection.java`

```java
package com.training.springboot.databse;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class DatabaseConnection implements InitializingBean, DisposableBean {

	@Value("localhost:1521")
	private String url;

	private String userName;
	private String password;

	public DatabaseConnection() {
		System.out.println("Database is created");
	}

	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }

	public String getUserName() { return userName; }

	@Value("root")
	public void setUserName(String userName) {
		System.out.println("Setting the value of username");
		this.userName = userName;
	}

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("This is afterPropertiesSet() call — Bean initialized");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Releasing resources — Bean destroyed");
	}
}
```

### 🧩 Key Terminology:

| Term | Description |
|------|--------------|
| **@Component** | Marks this class as a Spring-managed bean |
| **@Value** | Injects literal values into bean fields |
| **InitializingBean** | Interface used to execute logic *after* bean properties are set |
| **DisposableBean** | Interface used to execute logic *before* bean destruction |
| **@Scope("prototype")** | Creates a new instance of the bean each time it’s requested (default is `singleton`) |

---

## 📧 5. Email Bean — `EmailConnection.java`

```java
package com.training.springboot.databse;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class EmailConnection {

	public EmailConnection() {
		System.out.println("Email is created");
	}

	@PostConstruct
	public void logicBeanCreation() {
		System.out.println("This is life cycle method: After Construction and Configuration");
	}

	@PreDestroy
	public void logicOnBeanDestruction() {
		System.out.println("This is life cycle method: Before Destruction");
	}

	public void email2LifeCycle() {
		System.out.println("email2LifeCycle..............");
	}

	public void email2LifeCycleDestroy() {
		System.out.println("email2LifeCycleDestroy.................................");
	}
}
```

### 🧩 Key Annotations:

| Annotation | Description |
|-------------|--------------|
| **@PostConstruct** | Runs immediately after the bean is created and dependencies are injected |
| **@PreDestroy** | Runs right before the bean is destroyed |
| **@Component** | Registers the class as a Spring-managed component |

---

## ⚙️ 6. Java Configuration — `SprinBeansConfiguration.java`

```java
package com.training.springboot.databse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SprinBeansConfiguration {

	@Bean(initMethod = "email2LifeCycle", destroyMethod = "email2LifeCycleDestroy")
	public EmailConnection emailConnection2() {
		return new EmailConnection();
	}

	@Bean
	public EmailConnection emailConnection3() {
		return new EmailConnection();
	}
}
```

### 🧠 Explanation:
- **@Configuration** — tells Spring that this class provides bean definitions.
- **@Bean** — manually creates and registers beans in the container.
- **initMethod / destroyMethod** — specify custom initialization and cleanup methods.

---

## 🔁 7. Bean Lifecycle Summary

Here’s how the **Bean Lifecycle** works:

| Phase | Description | Method/Annotation |
|-------|--------------|-------------------|
| 1️⃣ Creation | Object is created (constructor called) | Constructor |
| 2️⃣ Dependency Injection | Values are injected (@Value, @Autowired) | - |
| 3️⃣ Initialization | Custom logic after dependencies are set | `afterPropertiesSet()` / `@PostConstruct` |
| 4️⃣ Ready to Use | Bean is available for use | - |
| 5️⃣ Destruction | Cleanup before bean is removed | `destroy()` / `@PreDestroy` |

---

## 🌍 8. Singleton vs Prototype Scope

| Feature | Singleton | Prototype |
|----------|------------|-----------|
| Instances | Only one per Spring container | New instance for each request |
| Default Scope | ✅ Yes | ❌ No |
| Lifecycle Management | Fully managed by container | Only initialization managed |
| Example Use Case | Service / Repository | Temporary objects or DTOs |

To make a bean **prototype**, uncomment:
```java
@Scope("prototype")
```

---

## 🧾 9. Console Output (Example)

```
Database is created
Setting the value of username
This is afterPropertiesSet() call — Bean initialized
Email is created
This is life cycle method: After Construction and Configuration
Email is created
email2LifeCycle..............
```

---

## 🧠 10. Summary

| Concept | Key Idea |
|----------|-----------|
| **Spring Container** | Manages creation, initialization, and destruction of beans |
| **Bean Lifecycle** | Sequence of events from creation → use → destruction |
| **@PostConstruct & @PreDestroy** | Annotation-based lifecycle management |
| **InitializingBean & DisposableBean** | Interface-based lifecycle management |
| **@Bean (initMethod/destroyMethod)** | Java config-based lifecycle management |
| **@Scope("prototype")** | Creates multiple bean instances |
| **Default scope** | Singleton |

---

✅ **Learning Tip:**  
When learning Spring Boot Bean lifecycle:
1. Start with `@Component` and understand how Spring creates beans.  
2. Then add lifecycle interfaces (`InitializingBean`, `DisposableBean`).  
3. Finally, move to annotations (`@PostConstruct`, `@PreDestroy`) and configuration-based beans.

---

**Author:** Raushan Singh  
**Topic:** Spring Boot – Bean Lifecycle and Scope  
**Level:** Beginner → Intermediate → Advanced

# Spring Boot Runners (CommandLineRunner & ApplicationRunner)

This section explains **Spring Boot Runners** — a powerful feature that allows developers to execute specific logic **right after the application starts**. It includes full code examples and beginner-to-advanced explanations.

---

## 🧩 What Are Runners in Spring Boot?

Runners are special classes that execute **immediately after** the Spring Boot application context has been initialized (i.e., after `SpringApplication.run()` completes).

They are typically used for:

* Initializing configuration data.
* Connecting to external systems (like sending notifications, emails, etc.).
* Executing startup logic only once when the app boots.

Spring Boot provides **two types of runners**:

1. **CommandLineRunner** → Access command-line arguments as a `String... args` array.
2. **ApplicationRunner** → Access command-line arguments as an `ApplicationArguments` object (structured form).

Both interfaces have a single abstract method called `run()` which is automatically executed at application startup.

---

## 🧱 Example: Application Setup

### **`Application.java`**

```java
package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.beans.Product;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("Args size :" + args.length);
        System.out.println("Args value :" + args);
        for (String arg : args) {
            System.out.println(arg);
        }

        System.out.println("Before Run Method");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        System.out.println("After Run Method");
        Product product = context.getBean(Product.class);
        System.out.println(product);
    }
}
```

### **Explanation**

* The application prints command-line arguments.
* It initializes the Spring context.
* Runners (explained below) are executed **automatically after** `SpringApplication.run()`.

---

## 🧠 Understanding CommandLineRunner

### **Definition**

`CommandLineRunner` is a functional interface with one method:

```java
void run(String... args) throws Exception;
```

* It receives command-line arguments as a **String array**.
* Executes once right after the application starts.

### **Example: Email Notification Runner**

```java
package com.training.springboot.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class EmailNotificationRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("This is CommandLineRunner...");
        System.out.println("Application is ready to operate.");
        System.out.println("Sending email to developer...");
        System.out.println("Email successfully sent!");
    }

    public void runAnother() {
        System.out.println("This is not part of Spring Boot runner method");
    }
}
```

### **Key Points**

* Marked with `@Component` → Automatically discovered by Spring Boot.
* `@Order(1)` → Ensures the runner runs **first** if multiple runners exist.
* The `run()` method executes logic like sending emails after startup.

---

## 📱 Another Example: Push Notification Runner

```java
package com.training.springboot.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class PushNotification implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("Sending push notification to manager team...");
        System.out.println("Push notification sent!");
    }
}
```

### **Explanation**

* Uses `@Order(3)` → This runner executes **after** Email and TextMessage runners.
* Demonstrates how multiple runners can run in sequence.

---

## 💬 Understanding ApplicationRunner

### **Definition**

`ApplicationRunner` is another interface used for post-startup logic, but it provides arguments as an **ApplicationArguments** object:

```java
void run(ApplicationArguments args) throws Exception;
```

* Gives structured access to **option** and **non-option** arguments.

### **Example: Text Message Notification**

```java
package com.training.springboot.runners;

import java.util.List;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class TextMessageNotification implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> values = args.getNonOptionArgs();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println("Sending Text Message to Management...");
    }
}
```

### **Key Points**

* `ApplicationArguments` gives more control than simple `String... args`.
* Helps when parsing arguments passed during application startup.

---

## 🧱 Supporting Bean Example

### **Product.java**

```java
package com.training.springboot.beans;

import org.springframework.stereotype.Component;

@Component
public class Product {
    public Product() {
        System.out.println("Product is created");
    }
}
```

### **Explanation**

* A simple bean loaded at startup.
* Shows that beans are available when runners execute.

---

## ⚙️ Execution Flow

When you start the Spring Boot app:

1. `main()` executes → calls `SpringApplication.run()`.
2. Spring Boot loads the **ApplicationContext**.
3. All `@Component` beans are created.
4. Runners (`CommandLineRunner` / `ApplicationRunner`) execute **immediately after startup**.
5. The application becomes ready to process further requests.

---

## 🚦 Ordering Multiple Runners

When you have multiple runners, you can control execution order using:

```java
@Order(1) // Executes first
@Order(2) // Executes second
@Order(3) // Executes third
```

Lower order number = higher priority.

---

## 🔍 Comparison Table

| Feature          | CommandLineRunner            | ApplicationRunner                               |
| ---------------- | ---------------------------- | ----------------------------------------------- |
| Input Type       | String... args               | ApplicationArguments                            |
| Purpose          | Simple argument handling     | Structured argument handling                    |
| Common Use       | Logging, emails, basic setup | Config initialization, complex argument parsing |
| Interface Method | `run(String... args)`        | `run(ApplicationArguments args)`                |

---

## 🧩 Real-World Use Cases

* Load default data into database after app start.
* Validate environment configuration.
* Send startup notification (email/SMS).
* Preload caches or configuration files.

---

## ✅ Summary

* **Runners = Post-startup executors.**
* Use them for one-time startup logic.
* `@Order` defines execution sequence.
* `CommandLineRunner` for simple args, `ApplicationRunner` for structured args.

These concepts are **essential for backend developers** who want to manage initialization logic effectively in Spring Boot applications.


