package entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="course")
@Entity
public class Course {
	
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="course_id")
	 private Integer courseID;
	
	 @Column(name="course_name",nullable = false)
	 private String courseName;

	
	 @Column(name="duration")
	 private int duration;
	 
	 
	 @OneToMany(mappedBy = "course"/*,cascade=CascadeType.ALL, fetch = FetchType.LAZY*/)
	 private List<Batch> batches;

	
	 @ManyToMany(mappedBy = "courses") 
	 private List<Faculty> faculties; 
	 

	 
	


	public Course() {
		super();
	}


	public Course(Integer courseID, String courseName, int duration, List<Batch>batches , List<Faculty>faculties) 
	 {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.duration = duration;
		this.batches = batches;
		this.faculties=faculties;
	}


	public Course(String courseName, int duration, List<Batch>batches  , List<Faculty>faculties) {
		super();
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


	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + ", duration=" + duration + "]";
	}
	
	
	


	
	
}
	
	
	
	