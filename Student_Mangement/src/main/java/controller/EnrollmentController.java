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

import dto.EnrollmentDTO;
import service.IMPL.EnrollmentServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")

@Controller
public class EnrollmentController {

	@Autowired
	private EnrollmentServiceIMPL enrollmentServiceIMPL;
	
		//add a new Enrollment
		@PostMapping(path = "/save")
		public ResponseEntity<String> addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO)
		{
			String response = enrollmentServiceIMPL.addEnrollment(enrollmentDTO);
			
//			return ResponseEntity.ok(response);
			
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
		
		
		
		//get all Enrollments
		@GetMapping("/getAllEnrollments")
		public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments()
		{
			List<EnrollmentDTO> enrollments = enrollmentServiceIMPL.getAllEnrollments();
			
//			return ResponseEntity.ok(batches);
			 return new ResponseEntity<>(enrollments,HttpStatus.OK);

			
		}
		
		//get Enrollment by id
		
		@GetMapping("/{id}")
		public ResponseEntity<EnrollmentDTO>getEnrollmentById(@PathVariable Integer id)
		{
			EnrollmentDTO enrollmentDTO = enrollmentServiceIMPL.getEnrollmentById(id);
			
			return ResponseEntity.ok(enrollmentDTO);
			
		}
		
		//UPDATE A Enrollment
		@PutMapping("/{id}")
		public ResponseEntity<String> updateEnrollment(@PathVariable Integer id, @RequestBody EnrollmentDTO enrollmentDTO)
		{
			String response = enrollmentServiceIMPL.updateEnrollment(id, enrollmentDTO);
			
			return ResponseEntity.ok(response);
			
		}
		
		//Delete a department
		 @DeleteMapping("/delete/{id}")
		public ResponseEntity<Boolean>deleteEnrollment(@PathVariable Integer id)
		{
			boolean deleted = enrollmentServiceIMPL.deleteEnrollment(id);
			return ResponseEntity.ok(deleted);
		}
		
		
	
	
	
	
	
	
}
