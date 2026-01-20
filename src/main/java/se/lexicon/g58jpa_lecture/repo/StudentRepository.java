package se.lexicon.g58jpa_lecture.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.g58jpa_lecture.entity.Student;

import java.util.List;
import java.util.Optional;


//CRUD - Create, Read, Update, Delete

public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByFirstName(String firstName);

    Optional<Student> findByEmail(String email);



    // JPQL
    @Query(value = "SELECT s FROM Student s WHERE s.firstName = :firstName")
    //    @Query(value = "SELECT * FROM student WHERE first_name = :firstName", nativeQuery = true)
    List<Student> searchFindByFirstName(@Param("firstName")String firstName);




}