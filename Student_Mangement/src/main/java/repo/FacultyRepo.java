package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Integer>{

}
