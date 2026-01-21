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

       /*
       System.out.println("---- WITHOUT CASCADE ----");

        Address stockholm = new Address("Nygatan 1", "Stockholm", "12345");
        addressRepository.save(stockholm);

//        if(true) {throw new Exception("Ops! something Went wrong, Rollback");}
       // add @Transactional to the method to rollback transaction

        Student john = new Student("John", "Doe", "john@test.com");
        john.setAddress(stockholm);
        studentRepository.save(john);


        studentRepository.delete(john);
        addressRepository.delete(stockholm);


       System.out.println("---- WITH CASCADE ----");

       Address address2 = new Address("Stockholm", "Park Avenue", "11233");
       Student student2 = new Student("Cascade", "Hero", "cascade@example.com");
       student2.setAddress(address2);

       student2 = studentRepository.save(student2);

       System.out.println("Saved Student (with cascade): " + student2);

       studentRepository.delete(student2);

       System.out.println("Deleted Student (cascade also removed address)");

        //Also update an Address object in DB
//        john.getAddress().setPostalCode("543210");
*/

    }

}
