package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Course;

public interface CourseRepo extends JpaRepository<Course,Integer>{

}
