package com.app.raghu.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Student;
import com.app.raghu.exception.StudentNotFoundException;
import com.app.raghu.service.IStudentService;

@RestController
@RequestMapping("/v1/api/student") // v1/api/rest/student
public class StudentRestController {
	//Alt + up and down ( to shift line code)

	@Autowired
	private IStudentService service;

	// save
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(
			@RequestBody @Valid Student student) {

		Integer id = service.saveStudent(student);
		return new ResponseEntity<String>("Student '" + id + "' created sucessfully", HttpStatus.OK);
	}

	// getAll
	@GetMapping("/all")
	//@ApiOperation("FETCH ALL STUDENTS FORM APPLICATION")
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> list = service.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	// FetchOne
	@GetMapping("find/{id}")
	public ResponseEntity<?> fetchOneStudent(@PathVariable Integer id) {
		ResponseEntity<?> response = null;
		try {
			Student student = service.getOneStudent(id);
			response = new ResponseEntity<Student>(student, HttpStatus.OK);//200
		} catch (StudentNotFoundException snfe) {
			snfe.printStackTrace();
			//response = new ResponseEntity<String>(snfe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);//500
			throw snfe;
		}
		return response;
	}

	// delete
	@DeleteMapping("remove/{id}")
	//@ApiIgnore //do not show at swagger
	public ResponseEntity<String> deleteStudentById(
			@PathVariable Integer id){
		ResponseEntity<String> response = null;
		try {
			service.deleteStudent(id);
			response = new ResponseEntity<String>("Student '"+id+"' deleted successfully.",HttpStatus.OK);//200
		}catch(StudentNotFoundException e) {
			e.printStackTrace();
			//response = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);//500
			throw e;
		}
		return response;
	}

	// update
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student){ //based on json format so @RequestBody
		
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = new ResponseEntity<String>(
						"Student '"+student.getStdId()+"'updated successfully",HttpStatus.OK);
		}catch (StudentNotFoundException e) {
			e.printStackTrace();
			/*response = new ResponseEntity<String>(
						e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);*///500
			throw e;
		}
		
		return response;
	}
	
	
	
}
