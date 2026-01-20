package se.lexicon.g58jpa_lecture.repo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g58jpa_lecture.entity.Student;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    @DisplayName("Save Simon student")
    void testSaveStudent(){
        // Arrange: create a student instance
        Student student = new Student("Simon", "Elbrink", "simon@test.com");
        // Act: Save the student to the in-memory database
        Student saved = studentRepository.save(student);

        // Assert: Verify that the student was saved correctly with an ID
        assertThat(saved.getId()).isNotNull();
    }


    @Test
    @DisplayName("Find Simon by email")
    void testFindByEmail() {
        // Arrange: save a student with a known email
        Student student = new Student("Simon", "Elbrink", "simon@test.com");
        studentRepository.save(student);
        // Act: retrieve the student using a custom method
        Optional<Student> optionalStudent = studentRepository.findByEmail("simon@test.com");
        // Assert: check that the student was found
        assertThat(optionalStudent).isPresent();
    }

    @Test
    @DisplayName("Find Elnaz by first name")
    void testFindByFirstName() {
        // Arrange: save a student with a known first name
        Student student = new Student("Elnaz", "Smith", "elnaz@test.com");
        studentRepository.save(student);
        // Act: retrieve the student using findByFirstName method
        List<Student> students = studentRepository.findByFirstName("Elnaz");
        // Assert: check that the student was found
        Assertions.assertThat(students).hasSize(1);
        Assertions.assertThat(students.get(0).getFirstName()).isEqualTo("Elnaz");
    }


    @Test
    @DisplayName("Find all students: Mehrdad, Simon, Tobias")
    void testFindAll() {
        // Arrange: save 3 students
        studentRepository.save(new Student("Mehrdad", "Javan", "mehrdad.all@example.com"));
        studentRepository.save(new Student("Simon", "Jones", "simon.all@example.com"));
        studentRepository.save(new Student("Tobias", "Andersson", "tobias.all@example.com"));

        // Act: retrieve all students from the DB
        List<Student> students = studentRepository.findAll();

        // Assert: check that 3 students exist
        Assertions.assertThat(students).hasSize(3);
    }



}