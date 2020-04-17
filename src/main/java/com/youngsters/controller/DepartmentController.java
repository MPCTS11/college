package com.youngsters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.youngsters.model.Request;
import com.youngsters.model.Response;
import com.youngsters.model.Student;
import com.youngsters.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/deptstudentinfo")
	public Response createDeptStudentInfo(@RequestBody Request request) {
		String collegeName ="ANU";
		System.out.println("Request -->"+request);
		return departmentService.createDeptStudentInfo(request, collegeName);
		
		
	}   @GetMapping("/getdeptstudentinfo")
		public Request getCreateDeptStudentInfo(@RequestParam String deptId) {
			return departmentService.getCreateDeptStudentInfo(deptId);
			
		}
	@PutMapping("/editdeptstudentinfo")
	public Response editCreateDeptStudentInfo(@RequestBody Request request, @RequestParam String deptId) {
		return departmentService.editCreateDeptStudentInfo(request, deptId);
	}
	@GetMapping("/getstudentinfo")
	public List<Student> getListofStudents(){
		return departmentService.getListofStudents();
	}
	


}