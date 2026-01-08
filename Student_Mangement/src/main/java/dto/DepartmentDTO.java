package dto;

//import java.util.List;
//
//import entity.Faculty;
//import entity.Student;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public class DepartmentDTO {
	
	private Integer departmentId;
	
	private String departmentName;
	
//	private List<Student> students;
//	
//	private List<Faculty> faculties;

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

	/*
	 * public List<Student> getStudents() { return students; }
	 * 
	 * public void setStudents(List<Student> students) { this.students = students; }
	 * 
	 * public List<Faculty> getFaculties() { return faculties; }
	 * 
	 * public void setFaculties(List<Faculty> faculties) { this.faculties =
	 * faculties; }
	 */
	
	
}
