package dto;

import java.time.LocalDate;

import entity.Batch;
import entity.Student;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class EnrollmentDTO {
		
	
	
	private Integer enrollmentId;
	
	private LocalDate enrolledDate;
	

	private Student student;
	

	private Batch batch;
	
	


	public EnrollmentDTO() {
		super();
	}


	public EnrollmentDTO(Integer enrollmentId, LocalDate enrolledDate, Student student, Batch batch) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrolledDate = enrolledDate;
		this.student = student;
		this.batch = batch;
	}


	public Integer getEnrollmentId() {
		return enrollmentId;
	}


	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}


	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}


	public void setEnrolledDate(LocalDate enrolledDate) {
		this.enrolledDate = enrolledDate;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Batch getBatch() {
		return batch;
	}


	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
	
}
