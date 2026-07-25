package com.pramod.crud.cruddemo;

import com.pramod.crud.cruddemo.dao.StudentDAO;
import com.pramod.crud.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

//			queryForStudents(studentDAO);

			//queryForStudentsTheLastName(studentDAO);

			//updateStudent(studentDAO);

			//removeStudentById(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO stud) {
		System.out.println("Deleting all students");
		stud.deleteAll();
	}

	private void removeStudentById(StudentDAO studentDAO) {
		//retrieve the student
		int ID = 1;
		//Remove the student
		studentDAO.deleteStudentById(ID);
		System.out.println("Student removed Successfully....");

	}

	private void updateStudent(StudentDAO studentDAO) {
		//get the student
		int studentId = 1;
		System.out.println("retrieving the student with id : "+ studentId);
		Student theStudent = studentDAO.findById(studentId);

		//change the first name of the student
		System.out.println("Changing the name");
		theStudent.setFirstName("Prasad");

		//update the Object
		studentDAO.update(theStudent);

		//Display the updated Student

		System.out.println("Updated Student : " +theStudent);

	}

	private void queryForStudentsTheLastName(StudentDAO studentDAO) {
		//get students by last names
		List<Student> tempStudent = studentDAO.findByLastName("Mengade");

		//Display The Student
		for(Student tStudent : tempStudent ){
			System.out.println(tStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get List of students
		System.out.println("Getting all Students");
		List<Student> theStudent = studentDAO.findAll();
		//Display the Students
		System.out.println("The Students Are :");

		for(Student tempStudent : theStudent ){
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDao){
		// create Student Object
		System.out.println("Creating a student Object");
		Student tempStudent = new Student("Sujal","Wagh" ,"surajWagh@gmail.com");

		//Save the Student Object
		System.out.println("Saving the Student ...");
		studentDao.save(tempStudent);

		//retrieve the student object
		System.out.println("Retrieving the Student by id");
		int id = tempStudent.getId();
		Student student = studentDao.findById(id);

		//Display the Student
		System.out.println(student);

	}
	private void createMultipleStudent(StudentDAO studentDAO){
		// create Student object
		System.out.println("Creating the Student Objects..");
		Student tempStudent1 = new Student("Pramod","Mengade","pramodmengade07@gmail.com");
		Student tempStudent2 = new Student("Sanjana","Kuale","sanjanakudale3@gmail.com");
		Student tempStudent3 = new Student("Vishnuu","Bombade","vishnubombade@gmail.com");


		//insert Student Object
		System.out.println("Saving the Students.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
}
