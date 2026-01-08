package dto;

import java.util.List;

import entity.Course;

public class FacultyDTO {
	
	
	private int facultyId;

	private String facultyName;


	private String phoneNo;

	private String emailId;

	private String designation;

	private int noOfYearExperience;

	private int departmentId;

	private List<Course> courses;

	
	

	public FacultyDTO(int facultyId, String facultyName, String phoneNo, String emailId,
			String designation, int noOfYearExperience, int departmentId, List<Course>courses) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
//		this.courseHandeld = courseHandeld;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.designation = designation;
		this.noOfYearExperience = noOfYearExperience;
		this.departmentId = departmentId;
		this.courses=courses;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
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

	public int getNoOfYearExperience() {
		return noOfYearExperience;
	}

	public void setNoOfYearExperience(int noOfYearExperience) {
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
