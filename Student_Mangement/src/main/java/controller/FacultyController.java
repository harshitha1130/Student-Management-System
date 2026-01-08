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

import ExceptionHandler.FacultyNotFoundException;
import dto.FacultyDTO;
import service.IMPL.FacultyServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("api/v1/faculty")

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyServiceIMPL facultyServiceIMPL;
	
	 @PostMapping(path = "/save")
     public ResponseEntity<String> addFaculty(@RequestBody FacultyDTO facultyDTO)
     {
		 String response= facultyServiceIMPL.addFaculty(facultyDTO);
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
     }

	 
	 //GET ALL FACULTIES
	 @GetMapping("/getAllFaculties")
     public ResponseEntity<List<FacultyDTO>> getAllFaculties()
     {
        
		 List<FacultyDTO> faculties =  facultyServiceIMPL.getAllFaculties();
		 return new ResponseEntity<>(faculties,HttpStatus.OK);
     }
	 
	  //upadte Faculty
	 @PutMapping("/update")
	 public String updateFaculty(@RequestBody FacultyDTO facultyDTO)
	 {
	     return facultyServiceIMPL.updateFaculty(facultyDTO);

	 }
	 
	 
	 
	 //Delete Faculty by id
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteFaculty(@PathVariable("id") int facultyId)
	 {
		 try
		 {
			 boolean  isDeleted = facultyServiceIMPL.deleteFaculty(facultyId);
			 if(isDeleted)
			 {
				 return ResponseEntity.ok("Faculty  Deleted Successfully!..");
			 }
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty Not found");
			 
			 
			 
		 }
		 
		 catch(FacultyNotFoundException e)
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			 
		 }
		 
		 catch(Exception e)
		 {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					 .body("An error occured while deleting the Faculty");
		 }
		 

	 }
	 
	 
}
