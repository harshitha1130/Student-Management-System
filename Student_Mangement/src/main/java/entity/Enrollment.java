package entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "enrollment")
@Entity
public class Enrollment {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enrollmentId;
	
	@Column(name="enrolled_date")
	private LocalDate enrolledDate;
	
//	@ManyToOne
//	@JoinColumn(name = "student_id", nullable = false)
	
	
	@ManyToOne
	@JoinColumn(name="student_id",nullable=false)
	private Student student;
	
	
//	@ManyToOne
//	@JoinColumn(name="batch_id",nullable=false)
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="batch_id",nullable=false)
	private Batch batch;
	
	
	
	
	
	public Enrollment() {
		super();
	}
	

	public Enrollment(Integer enrollmentId, LocalDate enrolledDate, Student student, Batch batch) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrolledDate = enrolledDate;
		this.student = student;
		this.batch = batch;
	}



	
	
	public Enrollment(LocalDate enrolledDate, Student student, Batch batch) {
		super();
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