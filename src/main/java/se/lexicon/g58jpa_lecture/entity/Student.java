package se.lexicon.g58jpa_lecture.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Student {

    @Id
    @UuidGenerator
    @Column(nullable = false, updatable = false)
    private String id;

    @Setter
    @Column(length = 50, nullable = false)
    private String firstName;

    @Setter
    @Column(length = 50, nullable = false)
    private String lastName;

    @Setter
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    private boolean status;
    private LocalDateTime createDate;

    @Setter
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "address_id", unique = true)
    private Address address;


    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this); // Make in sync...
    }

    public void dropCourse(Course course) {
        courses.remove(course);
        course.getStudents().remove(this); // Make in sync...
    }


    @PrePersist
    public void prePersist() {
        System.out.println("Before persist:");
        System.out.println(this);

        this.status = true;
        this.createDate = LocalDateTime.now();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
