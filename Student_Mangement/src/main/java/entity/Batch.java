package entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="batch")
@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer batchId;
	
	@Column(name="batch_name",nullable = false)
	private String batchName;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
  
  
//	@ManyToOne
//	@JoinColumn(name="course_id",nullable=false)
	
	
	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="course_id",nullable=false)
	private Course course;

    //extra for good bi-directional
	@OneToMany(mappedBy="batch",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Enrollment>enrollments;
	

	public Batch() {
		super();
	}


	public Batch(Integer batchId, String batchName, LocalDate startDate, Course course, List<Enrollment>enrollments) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.startDate = startDate;
		this.course = course;
		this.enrollments=enrollments;
	}


	public Batch(String batchName, LocalDate startDate, Course course, List<Enrollment>enrollments) {
		super();
		this.batchName = batchName;
		this.startDate = startDate;
		this.course = course;
		this.enrollments=enrollments;

	}


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
