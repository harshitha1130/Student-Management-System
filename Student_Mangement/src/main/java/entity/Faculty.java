package entity;



import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="faculty_id")
	private Integer facultyId;

	@Column(name="faculty_name")
	private String facultyName;


	@Column(name="phoneNo")
	private String phoneNo;

	@Column(name="email")
	private String emailId;

	@Column(name="designation")
	private String designation;

	@Column(name="noOfYearExperience")
	private Integer noOfYearExperience;

	@Column(name="department_id")
	private int departmentId;
	

	@ManyToMany
	@JoinTable(
	    name = "faculty_course", 
	    joinColumns = @JoinColumn(name = "faculty_id"), 
	    inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Course> courses;


	public Faculty() {
		super();
	}


	public Faculty(Integer facultyId, String facultyName, String phoneNo, String emailId, String designation,
			Integer noOfYearExperience, int departmentId, List<Course> courses) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.designation = designation;
		this.noOfYearExperience = noOfYearExperience;
		this.departmentId = departmentId;
		this.courses = courses;
	}


	public Faculty(String facultyName, String phoneNo, String emailId, String designation, Integer noOfYearExperience,
			int departmentId, List<Course> courses) {
		super();
		this.facultyName = facultyName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.designation = designation;
		this.noOfYearExperience = noOfYearExperience;
		this.departmentId = departmentId;
		this.courses = courses;
	}


	public Integer getFacultyId() {
		return facultyId;
	}


	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}


	public String getFacultyName() {
		return facultyName;
	}


	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Integer getNoOfYearExperience() {
		return noOfYearExperience;
	}


	public void setNoOfYearExperience(Integer noOfYearExperience) {
		this.noOfYearExperience = noOfYearExperience;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	

}
