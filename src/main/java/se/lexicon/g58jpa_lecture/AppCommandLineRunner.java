package se.lexicon.g58jpa_lecture;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g58jpa_lecture.entity.Address;
import se.lexicon.g58jpa_lecture.repo.AddressRepository;
import se.lexicon.g58jpa_lecture.entity.Student;
import se.lexicon.g58jpa_lecture.repo.StudentRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    StudentRepository studentRepository;
    AddressRepository addressRepository;

    public AppCommandLineRunner(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

   @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(String... args) throws Exception {

        // TODO: Transaction - one unit of work ?

        Address stockholm = addressRepository.save(new Address("Nygatan 1", "Stockholm", "12345"));

//        if(true) {throw new Exception("Ops! something Went wrong, Rollback");}
       // add @Transactional to the method to rollback transaction

        Student john = new Student("John", "Doe", "john@test.com");
        john.setAddress(stockholm);
        studentRepository.save(john);

    }

}
