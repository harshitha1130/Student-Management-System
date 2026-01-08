package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Batch;

public interface BatchRepo extends JpaRepository<Batch,Integer> {
	
}
