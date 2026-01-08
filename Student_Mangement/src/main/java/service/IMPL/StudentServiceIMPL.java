package service.IMPL;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repo.StudentRepo;

import ExceptionHandler.StudentNotFoundException;
import dto.StudentDTO;
import entity.Department;
import entity.Student;
import repo.DepartmentRepo;
//import repo.StudentRepo;

@Service
public class StudentServiceIMPL {
	

	
	@Autowired
    private StudentRepo studentRepo;
	
	@Autowired
	private DepartmentRepo deptRepo;
	
	//-----Adding The Student------
	public String addStudent(StudentDTO studentDTO)
	{
		
		

 
		System.out.println("Department Present Check:"+studentDTO.getDepartmentId());

		 
		 Department department = deptRepo.findById(studentDTO.getDepartmentId())
	                .orElseThrow(() -> new RuntimeException("Department Not Found with Id : " + studentDTO.getDepartmentId()));
	 
		
		Student student = new Student(
				studentDTO.getStudentName(),
                studentDTO.getAge(),
                studentDTO.getGender(),
                studentDTO.getAddress(),
                studentDTO.getPhoneNo(),
                studentDTO.getEmailId(),
                department.getDepartmentId(),
                studentDTO.getEnrollments()
				);

		
//		student.setDepartment(department);
		studentRepo.save(student);
		return "Student " + student.getStudentName() + "Is added Successfully !..";
		
	}
	
	
	//-----TO GET ALL THE STUDENTS---
	public List<StudentDTO> getAllStudents() {
		// TODO Auto-generated method stub
		
		 List<Student> getStudents = studentRepo.findAll();
	        List<StudentDTO> studentDTOList = new ArrayList<>();
	        for(Student student:getStudents)
	        {
	            StudentDTO studentDTO = new StudentDTO(
	                   student.getStudentId(),
	                   student.getStudentName(),
	                   student.getAge(),
	                   student.getGender(),
	                   student.getAddress(),
	                   student.getPhoneNo(),
	                   student.getEmailId(),
	                   student.getDepartmentId(),
	                   student.getEnrollments()
	                   
	            );
	        	
	            studentDTOList.add(studentDTO);
	        }
	        return studentDTOList;
		
	}
	
	
	// -----TO UPDATE ALL THE STUDENT----
	
	public String updateStudent(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		   if(studentRepo.existsById(studentDTO.getStudentId()))
	        {
	            Student student = 
	            studentRepo.findById(studentDTO.getStudentId()).orElseThrow(()->new StudentNotFoundException("Student not found !..."));
	            
	            student.setStudentName(studentDTO.getStudentName());
	            student.setAge(studentDTO.getAge());
	            student.setGender(studentDTO.getGender());
	            student.setAddress(studentDTO.getAddress());
	            student.setPhoneNo(studentDTO.getPhoneNo());
	            student.setEmailId(studentDTO.getEmailId());
	            student.setDepartmentId(studentDTO.getDepartmentId());
	            student.setEnrollments(studentDTO.getEnrollments());
	            studentRepo.save(student);
	            return "Student Updated Successfully";
	            
	        }
	        else
	        {
	            throw new StudentNotFoundException("student not found!..");
	        }
		
	}
	
	
	// ----- delete the Student----
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		 if(studentRepo.existsById(id))
	        {
	            studentRepo.deleteById(id);
	            return true;
	        }
	        else
	        {
	        	throw new StudentNotFoundException("Student Not Found with id:"+ id);
	        	
	        }
	}
	
	
	
}
