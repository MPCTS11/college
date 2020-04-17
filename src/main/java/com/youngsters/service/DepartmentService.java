package com.youngsters.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youngsters.dao.DeptRepo;
import com.youngsters.dao.StudentRepo;
import com.youngsters.model.Department;
import com.youngsters.model.Request;
import com.youngsters.model.Response;
import com.youngsters.model.Student;

@Service
public class DepartmentService {
	@Autowired
	private DeptRepo deptRepo;

	@Autowired
	private StudentRepo studentRepo;

	public Response createDeptStudentInfo(Request request, String collegeName) {
		Response response = new Response();
		/*
		 * Department department = new Department();
		 * department.setDeptId(request.getDeptId());
		 * department.setDeptId(request.getDeptName());
		 */
		Department department = new Department(request.getDeptId(), request.getDeptName());
		Department departmentRes = deptRepo.save(department);
		if (departmentRes != null && request.getStudent().size() != 0) {
			for (Student student : request.getStudent()) {
				Student studRequest = new Student(student.getStudentId(), student.getName(), student.getDob(),
						student.getAddress(), request.getDeptId());
				studentRepo.save(studRequest);
			}
			response.setStatus("Deptment is succesfuly created");
		} else {
			response.setStatus("Deptment is not created");
		}
		return response;

	}

	public Request getCreateDeptStudentInfo(String deptId) {
		Request request = new Request();
		Optional<Department> department = deptRepo.findById(deptId);
		System.out.println(department);
		List<Student> student = studentRepo.findAll().stream().filter(s -> s.getdeptId().equalsIgnoreCase(deptId))
				.collect(Collectors.toList());
		System.out.println(student);
		if (department.isPresent()) {
			request.setDeptId(department.get().getDeptId());
			request.setDeptName(department.get().getDeptName());
		}
		request.setStudent(student);
		return request;

	}

	public Response editCreateDeptStudentInfo(Request request, String deptId) {
		Response response = new Response();
		Request req = getCreateDeptStudentInfo(deptId);
		if (req == null) {
			response = createDeptStudentInfo(request, "ANU");
		} else {
			if (!req.getDeptName().equalsIgnoreCase(request.getDeptName())) {
				Department department = new Department(request.getDeptId(), request.getDeptName());
				deptRepo.save(department);
			}
			for (Student student : request.getStudent()) {
				Student studRequest = new Student(student.getStudentId(), student.getName(), student.getDob(),
						student.getAddress(), request.getDeptId());
				studentRepo.save(studRequest);
			}
		}

		return response;

	}

	public List<Student> getListofStudents() {

		return studentRepo.findAll();

	}

}
