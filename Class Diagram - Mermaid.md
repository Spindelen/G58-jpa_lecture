````mermaid

classDiagram
    direction BT
    
    %% Entities
    
    class Student{
        - String id
        - String firstName
        - String lastName
        - String email
        - boolean status
        - LocalDateTime createDate
        - Address address
        - Set~Course~ courses
    }
    class Address {
        - Long id
        - String postalCode
        - String street
        - String city
        - Student student
    }
    
    class Course{
        - Long id
        - String courseName
        - Instrucor mainTeacher
    }
    
    class Instructor{
        - Long id
        - String name
    }
    
    
    %% Relationships
    Student <--> Address : One-To-One
    Course  --> Instructor : Many-To-One
    Student --> Course : Many-To-Many
    Course <-- Instructor: OneToMany (Optional)
    Student <-- Course: ManyToMany (Optional)
    
````