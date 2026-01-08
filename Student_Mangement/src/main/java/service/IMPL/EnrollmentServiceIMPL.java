package service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExceptionHandler.BatchNotFoundException;
import ExceptionHandler.EnrollmentNotFoundException;
import dto.EnrollmentDTO;
import entity.Batch;
import entity.Enrollment;
import entity.Student;
import repo.BatchRepo;
import repo.EnrollmentRepo;
import repo.StudentRepo;

@Service
public class EnrollmentServiceIMPL {

	@Autowired
	private EnrollmentRepo enrollmentRepo;
	
	@Autowired
	private StudentRepo stdentRepo;
	
	@Autowired 
	private BatchRepo batchRepo;
	
	
	
	//Add new Batch 
		public String addEnrollment(EnrollmentDTO enrollmentDTO)
		{
			
		Student student = stdentRepo.findById(enrollmentDTO.getStudent().getStudentId())
	                .orElseThrow(() -> new RuntimeException("Student Not Found with Id : " + enrollmentDTO.getStudent().getStudentId()));
			
		Batch batch = batchRepo.findById(enrollmentDTO.getBatch().getBatchId())
                .orElseThrow(() -> new RuntimeException("Batch Not Found with Id : " + enrollmentDTO.getBatch().getBatchId()));
		
		
		
		
		System.out.println("the Student id:"+ enrollmentDTO.getStudent().getStudentId());
			
			Enrollment enrollment = new Enrollment();
			
			enrollment.setEnrolledDate(enrollmentDTO.getEnrolledDate());
//			enrollment.setStudent(enrollmentDTO.getStudent());
//			enrollment.setBatch(enrollmentDTO.getBatch());
			enrollment.setStudent(student);
			enrollment.setBatch(batch);
			enrollmentRepo.save(enrollment);
			
			return "A User with name: "+enrollment.getStudent().getStudentName() + " is Enrolled with Enrollment id : " + Integer.toString(enrollment.getEnrollmentId()) + "is added successfully";
			
			/* return String.format("
			 * 💥Congratulations, Mr/Ms : %s! 💥\n\n " +
			 * 
			 * "🧑🏻‍🎓 you have been Successfully enrolled in our course.\n"+
			 * "📝 Enrollment ID: %s\n" +
			 * "👩🏻‍💻 Batch: %s\n\n" +
			 * "🙌 we're thrilled to have you on board! Best of Luck on this exciting leraning",enrollment.getStudent().getStudentName(),enrollment.getEnrollmentId(),enrollment.getBatch().getBatchName());  
			 *  
			 * 
			 * 
			 * 
			 * */
			
		}
		
		//get all Enrollments
				public List<EnrollmentDTO> getAllEnrollments()
				{
					List<Enrollment> enrollments = enrollmentRepo.findAll();
					List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
					
					for(Enrollment enrollment : enrollments)
					{
						EnrollmentDTO dto = new EnrollmentDTO();
						dto.setEnrollmentId(enrollment.getEnrollmentId());
						dto.setEnrolledDate(enrollment.getEnrolledDate());
						dto.setStudent(enrollment.getStudent());
						dto.setBatch(enrollment.getBatch());
						
						enrollmentDTOList.add(dto);
					}
					
					return enrollmentDTOList;
	
				}
				
				
				//get Enrollment by id
				public EnrollmentDTO getEnrollmentById(Integer id)
				{
					Enrollment enrollment = enrollmentRepo.findById(id)
				.orElseThrow(()-> new BatchNotFoundException("Enrollment is Not found with the ID: "+ id));
					
					EnrollmentDTO dto = new EnrollmentDTO();
					dto.setEnrollmentId(enrollment.getEnrollmentId());
					dto.setEnrolledDate(enrollment.getEnrolledDate());
					dto.setStudent(enrollment.getStudent());
					dto.setBatch(enrollment.getBatch());
		
					return dto;
					
				}
				
				//update a batch
				public String updateEnrollment(Integer id, EnrollmentDTO enrollmentDTO)
				{
						Enrollment enrollment = enrollmentRepo.findById(id)
								.orElseThrow(()->new EnrollmentNotFoundException("Enrollment  Not found with the ID: "+ id));
						
						enrollment.setEnrolledDate(enrollmentDTO.getEnrolledDate());
						
						enrollment.setStudent(enrollmentDTO.getStudent());
						enrollment.setBatch(enrollmentDTO.getBatch());
						
						enrollmentRepo.save(enrollment);
					    return "Enrollment updated successfully: "+ enrollment.getEnrollmentId();
					
				}
				
				//Delete a batch
				public boolean deleteEnrollment(Integer id)
				{

						 if(enrollmentRepo.existsById(id))
					        {
							 enrollmentRepo.deleteById(id);
					            return true;
					        }
					        else
					        {
					        	throw new EnrollmentNotFoundException("Enrollment is Not Found with id: " + id);
					        	
					        }
					
				}
				
				
				
			
				
				
				
		
}
