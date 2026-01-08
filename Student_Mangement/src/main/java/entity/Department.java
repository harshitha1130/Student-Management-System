package entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name = "department")
@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer departmentId;
	
	@Column(name="department_name", columnDefinition = "VARCHAR(255)")
	private String departmentName;
	
//	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Student> students;
	
//	
//	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JsonManagedReference
//	private List<Faculty> faculties;
	
	
	

	public Department() {
		super();
	}

	public Department(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
//		this.students = students;
//		this.faculties = faculties;
	}

	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
//		this.students = students;
//		this.faculties = faculties;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}
//
//	public List<Faculty> getFaculties() {
//		return faculties;
//	}
//
//	public void setFaculties(List<Faculty> faculties) {
//		this.faculties = faculties;
//	}

	
	
	

}
