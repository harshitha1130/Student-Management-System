package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.BatchDTO;
import entity.Batch;
import service.IMPL.BatchServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/batch")

@Controller
public class BatchController {

	@Autowired
	private BatchServiceIMPL batchServiceIMPL;
	
	

	//add a new department
	@PostMapping(path = "/save")
	public ResponseEntity<String> addBatch(@RequestBody BatchDTO batchDTO)
	{
		String response = batchServiceIMPL.addBatch(batchDTO);
		
//		return ResponseEntity.ok(response);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//get all Batches
	@GetMapping("/getAllBatch")
	public ResponseEntity<List<Batch>> getAllBatches()
	{
		List<Batch> batches = batchServiceIMPL.getAllBatches();
		
//		return ResponseEntity.ok(batches);
		 return new ResponseEntity<>(batches,HttpStatus.OK);

		
	}
	
	//get Batch by id
	@GetMapping("/{id}")
	public ResponseEntity<BatchDTO>getBatchById(@PathVariable Integer id)
	{
		BatchDTO batchDTO = batchServiceIMPL.getBatchById(id);
		
		return ResponseEntity.ok(batchDTO);
		
	}
	
	//UPDATE A DEPARTMENT
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBatch(@PathVariable Integer id, @RequestBody BatchDTO batchDTO)
	{
		String response = batchServiceIMPL.updateBatch(id, batchDTO);
		
		return ResponseEntity.ok(response);
		
	}
	
	//Delete a department
	 @DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean>deleteDepartment(@PathVariable Integer id)
	{
		boolean deleted = batchServiceIMPL.deleteBatch(id);
		return ResponseEntity.ok(deleted);
	}
	
	
	
	
	
}
