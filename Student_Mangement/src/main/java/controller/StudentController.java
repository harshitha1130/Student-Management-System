package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ExceptionHandler.StudentNotFoundException;
import dto.StudentDTO;
import service.IMPL.StudentServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")

@Controller
public class StudentController {

	@Autowired
	private StudentServiceIMPL studentServiceIMPL;
	
	 @PostMapping(path = "/save")
     public String addStudent(@RequestBody StudentDTO studentDTO)
     {
		 return studentServiceIMPL.addStudent(studentDTO);
     }
	 
	 // get all students
	 
     @GetMapping("/getAllStudents")
     public List<StudentDTO> getAllStudents()
     {
        
         return studentServiceIMPL.getAllStudents();
     }
     
     //upadte student
 @PutMapping("/update")
 public String updateStudent(@RequestBody StudentDTO studentDTO)
 {
     return studentServiceIMPL.updateStudent(studentDTO);

 }
 
 //delete student
 @DeleteMapping("/delete/{id}")
 public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId)
 {
	 try
	 {
		 boolean  isDeleted = studentServiceIMPL.deleteStudent(studentId);
		 if(isDeleted)
		 {
			 return ResponseEntity.ok("Student Deleted Successfully!..");
		 }
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not found");
		 
		 
		 
	 }
	 
	 catch(StudentNotFoundException e)
	 {
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		 
	 }
	 
	 catch(Exception e)
	 {
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				 .body("An error occured while deleting the student");
	 }
	 

 }
	
	
		
}
