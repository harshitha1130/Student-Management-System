package service.IMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ExceptionHandler.DepartmentNotFoundException;
import dto.DepartmentDTO;
import entity.Department;
import repo.DepartmentRepo;

@Service
public class DepartmentServiceIMPL {

	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	//Add a new DepartMent
	public String addDepartment(DepartmentDTO departmentDTO)
	{
		Department department = new Department();
		department.setDepartmentName(departmentDTO.getDepartmentName());
		departmentRepo.save(department);
		return "Department added successfully: " + department.getDepartmentName();
	}
	
	//get all department
	public List<DepartmentDTO> getAllDepartments()
	{
		List<Department> departments = departmentRepo.findAll();
		List<DepartmentDTO> departmentDTOList = new ArrayList<>();
		
		for(Department department : departments)
		{
			DepartmentDTO dto = new DepartmentDTO();
			dto.setDepartmentId(department.getDepartmentId());
			dto.setDepartmentName(department.getDepartmentName());
//			dto.setFaculties(department.getFaculties());
//			dto.setStudents(department.getStudents());
			departmentDTOList.add(dto);

		}
		
		
		return departmentDTOList;
		
	}
	
	//get department by id
	public DepartmentDTO getDepartmentById(Integer id)
	{
		Department department = departmentRepo.findById(id)
	.orElseThrow(()-> new DepartmentNotFoundException("Department is Not found with the ID: "+ id));
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDepartmentName());
//		dto.setStudents(department.getStudents());
//		dto.setFaculties(department.getFaculties());
		
		return dto;
		
	}
	
	//update a department
	public String updateDepartment(Integer id, DepartmentDTO departmentDTO)
	{
			Department department = departmentRepo.findById(id)
					.orElseThrow(()->new DepartmentNotFoundException("Department  Not found with the ID: "+ id));
			
			department.setDepartmentName(departmentDTO.getDepartmentName());
			departmentRepo.save(department);
		return "Department updated successfully: "+ department.getDepartmentName();
		
	}
	
	//Delete a Department
	public boolean deleteDepartment(Integer id)
	{
		if(!departmentRepo.existsById(id))
		{
			throw new DepartmentNotFoundException("Department  Not found with the ID: "+ id);
		}
		departmentRepo.deleteById(id);
		return true;
	}
	
	
}
