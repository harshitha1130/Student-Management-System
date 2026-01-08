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

import ExceptionHandler.CourseNotFoundException;
import dto.CourseDTO;
import entity.Course;
import service.IMPL.CourseServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Course")

@Controller
public class CourseController {
	
	@Autowired
	private CourseServiceIMPL courseServiceIMPL;
	
	
	//--Adding the Course---
	@PostMapping(path = "/save")
    public ResponseEntity<String> addCourse(@RequestBody  CourseDTO courseDTO)
    {
		 String response= courseServiceIMPL.addCourse(courseDTO);
		 return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
	
	

	 //GET ALL Courses
	 @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseDTO>> getAllCourses()
    {
       
		 List<CourseDTO> courses =  courseServiceIMPL.getAllCourses();
		 return new ResponseEntity<>(courses,HttpStatus.OK);
    }
	 
	 
	 //--GET THE COURSE BY ID----
	 @GetMapping("/{id}")
	 public ResponseEntity<Course>getCourseBYId(@PathVariable Integer id)
	 {
		 
		return ResponseEntity.ok(courseServiceIMPL.getCourseBYId(id));
		 
	 }
	 
	 
	 
	  //upadte The Courses
	 @PutMapping("/update")
	 public String updateCourse(@RequestBody CourseDTO courseDTO)
	 {
	     return courseServiceIMPL.updateCourse(courseDTO);

	 }
	 
	 
	//Delete Faculty by id
		 @DeleteMapping("/delete/{id}")
		 public ResponseEntity<String> deleteCourse(@PathVariable("id") int courseId)
		 {
			 try
			 {
				 boolean  isDeleted = courseServiceIMPL.deleteCourse(courseId);
				 if(isDeleted)
				 {
					 return ResponseEntity.ok("Faculty  Deleted Successfully!..");
				 }
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Faculty Not found");
				 
				 
				 
			 }
			 
			 catch(CourseNotFoundException e)
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
	 






/* 
 * @GetMapping 
 * public ResponseEntity<List<Course>getAllCourses()
 * {
 * 		return ResponseEntity.ok(courseService.getAllCourses());
 * }
 * 
 * @GetMapping("/{id}")
 * public ResponseEntity<Course> getcourseById(@PathVariable Integer id)
 * {
 * 		return ReponseEntity.ok(courseService.getCourseById(id));
 * }
 * 
 * @PostMapping
 * public ResponseEntity<Course> createCourse(@RequestBody Course course)
 * {
 * 		return ResponseEntity.ok(courseService.createCourse(course));
 * }
 * 
 * @PutMapping("/{id}")
 * public ResponseEntity<Course> updateCourse(@PathVariable Integer is, @RequestBody Course updatedCourse)
 * {
 * 		return ResponseEntity.ok(courseService.updateCourse(id,updatedCourse));
 * }
 * 
 * @DeleteMapping("/{id}")
 * public ResponseEntity<String> deleteCourse(@PathVariable Integer id)
 * {
 * 	courseService.deleteCourse(id);
 * 	return ResponseEntity.ok("course deletd " + id)
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
 