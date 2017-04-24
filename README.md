# Spring Boot Simple Security Tutorial
**An tutorial application using Spring Boot as REST API back-end.**

More details about the codes, please read the online **[Spring Boot](https://projects.spring.io/spring-boot).**

Requirements
------
Running in
+ [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.8 or newer
+ [Spring Boot](https://github.com/spring-projects/spring-boot) 1.5.2.RELEASE or newer
+ [Spring Security](https://spring.io/guides/gs/securing-web) 1.5.2.RELEASE or newer
+ [Gradle](https://github.com/gradle/gradle) 3.4.1 or newer

Optional
------
+ YAML

Dependencies
------
+ [org.springframework.boot:spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)
+ [javax.ws.rs:javax.ws.rs-api:2.0.1](https://mvnrepository.com/artifact/javax.ws.rs/javax.ws.rs-api)

Latest Update
------
+ 1.0 (Apr 24, 2017)

How to Run
------
+ Clone [this Git repository](https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial)
+ Build the project gradle build
+ Run the application **./gradlew bootRun**
```command
$ ./gradle bootRun
```

Test accoutns
------
+ Reference file [data.sql](https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial/blob/master/src/main/resources/data.sql)

#### admin
```sql
username: admin@me.com
password: admin
```

#### staff
```sql
username: staff@me.com
password: staff
```

API
------
#### Configuration
By default Spring Boot applications run on port **8080**.
But may vary depending on what ports are in use on your machine (check the terminal after entering the ./gradlew bootRun command).
If you require to change which port the application runs on by default, add the following to:

#### application.yml
```yml
server:
    port: 8080 # --> change other port via. 9090
```

Author
------
**warumono** - <warumono.for.develop@gmail.com>
