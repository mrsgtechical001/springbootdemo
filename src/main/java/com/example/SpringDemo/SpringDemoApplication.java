package com.example.SpringDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDemoApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("Application started");
//	}
    @Bean
    public CommandLineRunner commandLineRunner (StudentDao student){

        return runner ->{

//            StudentEntity entity = new StudentEntity("Android", "Developer","developer@android.com");

//            student.save(entity);
//            saveMultipleStudent(student);
//            System.out.println("student save successfully in database :-" + entity.getId() );
//            readDataFromDB(student);

//            getAllStudent(student);

//            findByLastName(student);

//                updateStudent(student);

//            deleteStudent(student);

            deleteAll(student);
        };
    }

    private void deleteAll(StudentDao student) {

       int deleteRowCount = student.deleteAll();

        System.out.println("delete successfully : "+deleteRowCount);
    }

    private void deleteStudent(StudentDao student) {


    }
//
    private void updateStudent(StudentDao student) {

        int studentId =1;
        StudentEntity studentEntity = student.findById(studentId);


        studentEntity.setFirstName("Raghav");

        student.equals(studentEntity);

        System.out.println("update Student : "+studentEntity);

        student.updateStudentDetails(studentEntity);
    }

    private void findByLastName(StudentDao student) {
        List<StudentEntity> list = student.findByLastName("Developer");

        for (StudentEntity lastName : list) {
            System.out.println("surname found :_"+lastName);

        }

    }

    private void getAllStudent(StudentDao student) {

        List<StudentEntity>list = student.findAll();

        for (StudentEntity s : list){

            System.out.println("student : "+s);

        }

    }

    private void readDataFromDB(StudentDao student) {

        StudentEntity entity1 = new StudentEntity("Sagar", "Developer","developer@android.com");
        int id = entity1.getId();

        System.out.println("search Student found :_"+ student.findById(id));


    }

    private void saveMultipleStudent(StudentDao student) {
        

        StudentEntity entity1 =new StudentEntity("Sagar", "Developer","developer@android.com");
        StudentEntity entity2 =new StudentEntity("Sahil", "Developer","developer@android.com");
        StudentEntity entity3 =new StudentEntity("Shrukhal", "Developer","developer@android.com");
        
        student.save(entity1);
        student.save(entity2);
        student.save(entity3);

        System.out.println("students added : "+ " id :"+entity1.getId() + " name :"+ entity1.getFirstName());
        System.out.println("students added : "+ " id :"+entity2.getId() + " name :"+ entity2.getFirstName());
        System.out.println("students added : "+ " id :"+entity3.getId() + " name :"+ entity3.getFirstName());


        
        
    }

}
