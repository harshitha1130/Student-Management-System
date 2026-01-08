package dto;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data

import java.util.List;

import entity.Batch;
import entity.Faculty;

public class CourseDTO {


	 private Integer courseID;
	
	 private String courseName;

	
	 private int duration;
	 
	 private List<Batch> batches;

	 private List<Faculty> faculties; 



	public CourseDTO(Integer courseID, String courseName, int duration, List<Batch>batches, List<Faculty>faculties) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.duration = duration;
		this.batches = batches;
		this.faculties=faculties;
	}


	public Integer getCourseID() {
		return courseID;
	}


	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public List<Batch> getBatches() {
		return batches;
	}


	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}


	public List<Faculty> getFaculties() {
		return faculties;
	}


	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	 
	 
}
