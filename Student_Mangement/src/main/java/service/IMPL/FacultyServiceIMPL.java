package service.IMPL;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExceptionHandler.FacultyNotFoundException;
import dto.FacultyDTO;
import entity.Department;
import entity.Faculty;
import repo.DepartmentRepo;
import repo.FacultyRepo;

@Service
public class FacultyServiceIMPL {
	
	@Autowired
    private FacultyRepo facultyRepo;
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	//-----Adding The Faculty------
	public String addFaculty(FacultyDTO facultyDTO)
	{
		
//		 Department department = new departmentRepo.findById(facultyDTO.getDepartment().getDepartmentId()).
//		  orElseThrow(()-> new ResourceNotFoundException("Department Not Found with Id:"+ facultyDTO.getDepartment().getDepartmentId()  ));	  
		 
		System.out.println("Department Present Check:"+facultyDTO.getDepartmentId());

		 
		 Department department = departmentRepo.findById(facultyDTO.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department Not Found with Id : " + facultyDTO.getDepartmentId()));
	 
		
		
			Faculty faculty = new Faculty(
				
				facultyDTO.getFacultyName(),
				facultyDTO.getPhoneNo(),
				facultyDTO.getEmailId(),
				facultyDTO.getDesignation(),
				facultyDTO.getNoOfYearExperience(),
                department.getDepartmentId(),
				facultyDTO.getCourses()
				);
			
		
		facultyRepo.save(faculty);
		return "Faculty " + faculty.getFacultyName() + "Is added Successfully !..";
		
	}
	
	
	//-----TO GET ALL THE Faculty---
	public List<FacultyDTO> getAllFaculties() {
		// TODO Auto-generated method stub
		
		 List<Faculty> getfaculties = facultyRepo.findAll();
		 
	     List<FacultyDTO> facultyDTOList = new ArrayList<>();
		 
			/*
			 * return getfaculties.stream().map(faculty-> new
			 * FacultyDTO(faculty.getFacultyId(), faculty.getFacultyName(),
			 * faculty.getAddress(), faculty.getPhoneNo(), faculty.getEmailId(),
			 * faculty.getDesignation(), faculty.getNoOfYearExperience(),
			 * faculty.getDepartment().getDepartmentId())).collect(Collectors.toList());
			 */
				 
				 
				 
				 
				 
		 
	        for(Faculty faculty:getfaculties)
	        {
	            FacultyDTO studentDTO = new FacultyDTO(
	            		faculty.getFacultyId(),
	            		faculty.getFacultyName(),
	            		faculty.getPhoneNo(),
	            		faculty.getEmailId(),
	            		faculty.getDesignation(),
	            		faculty.getNoOfYearExperience(),
	            		faculty.getDepartmentId(),
	            		faculty.getCourses()
	                   
	            );
	            facultyDTOList.add(studentDTO);
	        }
	        return facultyDTOList;
		
		
	}
	
	
	// -----TO UPDATE ALL THE STUDENT----
	
	public String updateFaculty(FacultyDTO facultyDTO) {
		System.out.println("Id:"+facultyDTO.getFacultyId());
		
		   if(facultyRepo.existsById(facultyDTO.getFacultyId()))
	        {
	            Faculty faculty = 
	            	facultyRepo.findById(facultyDTO.getFacultyId()).orElseThrow(()->new FacultyNotFoundException("Student not found !..."));
	            faculty.setFacultyName(facultyDTO.getFacultyName());
	            
	            
	            faculty.setPhoneNo(facultyDTO.getPhoneNo());
	            
	            faculty.setEmailId(facultyDTO.getEmailId());
	            
	            faculty.setDesignation(facultyDTO.getDesignation());
	            
	            faculty.setNoOfYearExperience(facultyDTO.getNoOfYearExperience());
	            
	            faculty.setDepartmentId(facultyDTO.getDepartmentId());
	            
	            faculty.setCourses(facultyDTO.getCourses());
	            
	            
	            facultyRepo.save(faculty);
	            return "Faculty" + faculty.getFacultyName()+ "is Updated Successfully";
	            
	        }
	        else
	        {
	            throw new FacultyNotFoundException("Hey User Faculty is not found!..");
	        }
		
	}
	
	
	// ----- delete the Faculty----
	public boolean deleteFaculty(int id) {
		// TODO Auto-generated method stub
		 if(facultyRepo.existsById(id))
	        {
			    facultyRepo.deleteById(id);
	            return true;
	        }
	        else
	        {
	        	throw new FacultyNotFoundException("Faculty is Not Found with id:"+ id);
	        	
	        }
	}
	
}
