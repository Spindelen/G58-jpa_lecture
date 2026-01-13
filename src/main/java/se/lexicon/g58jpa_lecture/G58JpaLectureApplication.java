package se.lexicon.g58jpa_lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class G58JpaLectureApplication {

    public static void main(String[] args) {
        // Do not write more code here...
        SpringApplication.run(G58JpaLectureApplication.class, args);
    }

/*
What Happens When We Run This Class with Spring Data JPA?
When we run our Spring Boot application that includes this Student class,
a lot of things happen automatically behind the scenes, thanks to Spring Data JPA and Hibernate.


When you run the application, Spring Boot initializes everything — including 'spring-boot-starter-data-jpa' that contains Hibernate and Spring Data JPA and ...
It scans the project and finds all the classes annotated with @Entity, like our Student class.

The @Entity annotation tells Hibernate:
“Hey, this is a table in the database!”

Hibernate will then map this class to a table in the database, using the class name (Student) as the default table name.
If you’ve enabled automatic schema generation (via the application.properties), Hibernate will:
Create a table called student
Add columns based on your fields and annotations

@Column(nullable = false, length = 100) tells Hibernate to:
Make the column required (not null)
Limit the character length (like VARCHAR(100))

So when we run the application, Spring Boot and Hibernate will automatically recognize the Student class as a database table,
Next: generate the table and columns with their relationships.
*/

}
