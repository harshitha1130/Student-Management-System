package service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExceptionHandler.CourseNotFoundException;
import ExceptionHandler.FacultyNotFoundException;

import java.util.Optional;
import dto.CourseDTO;
import entity.Course;
import repo.CourseRepo;

@Service
public class CourseServiceIMPL {
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	//-----Adding The Course------
		public String addCourse(CourseDTO courseDTO)
		{
			
		
			
			
				Course course = new Course(
					
						courseDTO.getCourseName(),
						courseDTO.getDuration(),
						courseDTO.getBatches(),
						courseDTO.getFaculties()
						);
				
			courseRepo.save(course);
			return "Course " + course.getCourseName() + " Is added Successfully !..";
			
		}
		
		
		//-----TO GET ALL THE Course---
		
		public List<CourseDTO> getAllCourses() {
			
			 List<Course> getcourses = courseRepo.findAll();
			 
		     List<CourseDTO> courseDTOList = new ArrayList<>();
			 
		     	for(Course course:getcourses)
		        {
		            CourseDTO courseDTO = new CourseDTO(
		            		course.getCourseID(),
		            		course.getCourseName(),
		            		course.getDuration(),
		            		course.getBatches(),
		            		course.getFaculties()
		          );
		            
		            courseDTOList.add(courseDTO);
		        }
		        return courseDTOList;
			
		}

		
		//----TO GET  THE COURSE BY ID-----
		public Course getCourseBYId(Integer courseId)
		{
			Optional<Course> optionalCourse = courseRepo.findById(courseId);
			if(optionalCourse.isPresent())
			{
				return optionalCourse.get();
			}
			else
			{
				throw new RuntimeException("Course Not Found with Id : " + courseId);
			}
			
		}
		
		
		//--- to update the Course----
		
		public String updateCourse(CourseDTO courseDTO) {
			// TODO Auto-generated method stub
			System.out.println("Id:"+courseDTO.getCourseID());
			   if(courseRepo.existsById(courseDTO.getCourseID()))
		        {
		            Course course = 
		            	courseRepo.findById(courseDTO.getCourseID()).orElseThrow(()->new CourseNotFoundException("Hey User Course is not found !..."));
		            
		            
		            course.setCourseName(courseDTO.getCourseName());
		            
		            course.setDuration(courseDTO.getDuration());
		            
		            courseRepo.save(course);
		            return "Hey User Course is Updated Successfully !....";
		        }
		        else
		        {
		            throw new FacultyNotFoundException("Hey User Course is not found!..");
		        }
			
		}
		
		// ----- delete the Course----
		public boolean deleteCourse(int id) {
			// TODO Auto-generated method stub
			 if(courseRepo.existsById(id))
		        {
				    courseRepo.deleteById(id);
		            return true;
		        }
		        else
		        {
		        	throw new CourseNotFoundException("Course is Not Found with id:"+ id);
		        	
		        }
		}
		
		
		
	
	

}
