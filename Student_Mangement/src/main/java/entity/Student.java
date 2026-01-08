package entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="student")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phoneNo;
	
	@Column(name="email")
	private String emailId;
	
	
	@Column(name="department_id")
	private int departmentId;
	  
	  
	  
		
	//adding extra to enhance the code
		  
	 @OneToMany(mappedBy="student", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	 private  Set<Enrollment>enrollments;




	public Student() {
		super();
	}




	public Student(String studentName, Integer age, String gender, String address, String phoneNo, String emailId,
			int departmentId, Set<Enrollment> enrollments) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.departmentId = departmentId;
		this.enrollments = enrollments;
	}




	public Student(Integer studentId, String studentName, Integer age, String gender, String address, String phoneNo,
			String emailId, int departmentId, Set<Enrollment> enrollments) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.departmentId = departmentId;
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




	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}




	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	 
	
	
}
