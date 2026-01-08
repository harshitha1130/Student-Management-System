package service.IMPL;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExceptionHandler.BatchNotFoundException;
import dto.BatchDTO;
import entity.Batch;
import entity.Course;
import entity.Enrollment;
import repo.BatchRepo;
import repo.CourseRepo;




@Service
public class BatchServiceIMPL {

	@Autowired
	private BatchRepo batchRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	//Add new Batch 
	public String addBatch(BatchDTO batchDTO) {
	    System.out.println("Entered the save method via service");

	    // Fetch the course entity
	    Course course = courseRepo.findById(batchDTO.getCourse().getCourseID())
	            .orElseThrow(() -> new RuntimeException("Course Not Found with ID: " + batchDTO.getCourse().getCourseID()));

	    System.out.println("Course ID: " + batchDTO.getCourse().getCourseID());

	    // Map BatchDTO to Batch
	    Batch batch = new Batch();
	    batch.setBatchName(batchDTO.getBatchName());
	    batch.setStartDate(batchDTO.getStartDate());

	    // Map and associate enrollments
	    List<Enrollment> enrollments = batchDTO.getEnrollments().stream()
	            .map(enrollmentDTO -> {
	                Enrollment enrollment = new Enrollment();
	                enrollment.setStudent(enrollmentDTO.getStudent());
	                enrollment.setBatch(batch);  // Link batch with enrollment
	                return enrollment;
	            })
	            .collect(Collectors.toList());
	    batch.setEnrollments(enrollments);

	    batch.setCourse(course);

	    // Save the batch
	    batchRepo.save(batch);
	    return "Batch added successfully: " + batch.getBatchName();
	}

	
	
	
	//get all batch
//		public List<BatchDTO> getAllBatches()
//		{
//			List<Batch> batches = batchRepo.findAll();
//			List<BatchDTO> batchDTOList = new ArrayList<>();
//			
//			for(Batch batch : batches)
//			{
//				BatchDTO dto = new BatchDTO();
//				dto.setBatchId(batch.getBatchId());
//				dto.setBatchName(batch.getBatchName());
//				dto.setStartDate(batch.getStartDate());
//				dto.setCourse(batch.getCourse());
//				dto.setEnrollments(batch.getEnrollments());
//				batchDTOList.add(dto);
//			}
//			
//			
//			return batchDTOList;
//			
//		}
	public List<Batch> getAllBatches()
	{
		List<Batch> batchDTO=batchRepo.findAll();
		return batchDTO;
	}

		
		//get batch by id
		public BatchDTO getBatchById(Integer id)
		{
			Batch batch = batchRepo.findById(id)
		.orElseThrow(()-> new BatchNotFoundException("Department is Not found with the ID: "+ id));
			
			BatchDTO dto = new BatchDTO();
			dto.setBatchId(batch.getBatchId());
			dto.setBatchName(batch.getBatchName());
			dto.setStartDate(batch.getStartDate());
			dto.setCourse(batch.getCourse());
			dto.setEnrollments(batch.getEnrollments());
			return dto;
			
		}
		
		//update a batch
		public String updateBatch(Integer id, BatchDTO batchDTO)
		{
				Batch batch = batchRepo.findById(id)
						.orElseThrow(()->new BatchNotFoundException("Department  Not found with the ID: "+ id));
				
				batch.setBatchName(batchDTO.getBatchName());
				
				batch.setStartDate(batchDTO.getStartDate());
				batch.setCourse(batchDTO.getCourse());
				batch.setEnrollments(batchDTO.getEnrollments());
				
				batchRepo.save(batch);
			    return "Department updated successfully: "+ batch.getBatchName();
			
		}
		
		//Delete a batch
		public boolean deleteBatch(Integer id)
		{

				 if(batchRepo.existsById(id))
			        {
					 	batchRepo.deleteById(id);
			            return true;
			        }
			        else
			        {
			        	throw new BatchNotFoundException("Batch is Not Found with id: " + id);
			        	
			        }
			
		}
		
		
	
	
}
