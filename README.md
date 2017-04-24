# Spring Boot Simple Security Tutorial
**An tutorial application using Spring Boot as REST API back-end.**

Preview
------
<div style="display: inline-block;">
<img src="https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial/blob/master/src/main/resources/static/app/previews/spring-security-simple-security-tutorial-crossroads.png" width="900px;">
<img src="https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial/blob/master/src/main/resources/static/app/previews/spring-security-simple-security-tutorial-registration.png" width="900px;">
<img src="https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial/blob/master/src/main/resources/static/app/previews/spring-security-simple-security-tutorial-login.png" width="900px;">
<img src="https://github.com/warumono-for-develop/spring-boot-simple-security-tutorial/blob/master/src/main/resources/static/app/previews/spring-security-simple-security-tutorial-denied.png" width="900px;">
</div>

More details about the codes, please read the online **[Spring Boot](https://projects.spring.io/spring-boot).**

Requirements
------
Running in
+ [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 1.8 or newer
+ [Spring Boot](https://github.com/spring-projects/spring-boot) 1.5.2.RELEASE or newer
+ [Gradle](https://github.com/gradle/gradle) 3.4.1 or newer

Optional
------
+ YAML

Dependencies
------
+ [org.springframework.boot:spring-boot-starter-security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
+ [org.springframework.boot:spring-boot-starter-data-jpa](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
+ [org.springframework.boot:spring-boot-starter-thymeleaf](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf)
+ [org.springframework.boot:spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)

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

Test accounts
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
