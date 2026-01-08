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

import dto.DepartmentDTO;
import service.IMPL.DepartmentServiceIMPL;

@RestController
@CrossOrigin
@RequestMapping("api/v1/departments")

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentServiceIMPL departmentService;
	
	//add a new department
	@PostMapping(path = "/save")
	public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO departmentDTO)
	{
		String response = departmentService.addDepartment(departmentDTO);
//		return ResponseEntity.ok(response);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//get all departments
	@GetMapping("/getAllDepartment")
	public ResponseEntity<List<DepartmentDTO>> getAllDepartments()
	{
		List<DepartmentDTO> departments =departmentService.getAllDepartments();
		
		return ResponseEntity.ok(departments);
//		 return new ResponseEntity<>(departments,HttpStatus.OK);

		
	}
	
	//get department by id
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDTO>getDepartmentById(@PathVariable Integer id)
	{
		DepartmentDTO departmentDTO = departmentService.getDepartmentById(id);
		
		return ResponseEntity.ok(departmentDTO);
		
	}
	
	//UPDATE A DEPARTMENT
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDTO departmentDTO)
	{
		String response = departmentService.updateDepartment(id, departmentDTO);
		
		return ResponseEntity.ok(response);
		
	}
	
	//Delete a department
	 @DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean>deleteDepartment(@PathVariable Integer id)
	{
		boolean deleted = departmentService.deleteDepartment(id);
		return ResponseEntity.ok(deleted);
	}
}
