package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Enrollment;


public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer>{
  
}
