package dto;

import java.util.Set;

import entity.Enrollment;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class StudentDTO {

private Integer studentId;
	
	private String studentName;
	
	private Integer age;
	
	private String gender;
	
	private String address;
	
	private String phoneNo;
	
	private String emailId;
	
	
	private int departmentId;
	  
	  
	private  Set<Enrollment>enrollments;
	
	public StudentDTO(Integer studentId, String studentName, Integer age, String gender, String address, String phoneNo,
			String emailId, int departmentId, Set<Enrollment>enrollments) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.departmentId= departmentId;
		this.enrollments=enrollments;
	}

	

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}



	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}



	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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



	public int getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	
	
	
}
