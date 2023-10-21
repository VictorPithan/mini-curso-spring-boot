# Short course Development of Rest APIs with Java, Spring and Solid Pattern

## Some important settings

### PostgreSQL configuration

* Run through the terminal:
    ``` bash
    psql -h localhost -U postgres
    ```
    
    ``` sql
    CREATE DATABASE minicurso;
    ```

### application.properties

[🔗 Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.web)

``` properties
spring.datasource.url=jdbc:postgresql://localhost:5432/minicurso
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

* Run through the terminal:
    
    ``` bash
    mvn spring-boot:run
    ```

### Relational Modeling

[📂 Relational Model](./Minicurso-Java-Spring.pdf)

---

### 📋 Start documentation made with Swagger
#### After start the project with `npm run start:dev`, enter [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

Developed 💛 by Victor Pithan