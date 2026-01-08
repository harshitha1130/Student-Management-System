package dto;

import java.time.LocalDate;
import java.util.List;

import entity.Course;
import entity.Enrollment;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class BatchDTO {


	private Integer batchId;
	
	private String batchName;
	
	private LocalDate startDate;
  
	private Course course;
	
	private List<Enrollment>enrollments;

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	
	
}
