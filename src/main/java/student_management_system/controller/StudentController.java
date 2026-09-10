package student_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import student_management_system.entity.Student;
import student_management_system.service.StudentService;
 


@CrossOrigin(origins = "http://localhost:5175")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/api/v1/students")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		
		Student savedStudent = studentService.saveStudent(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
	}
	
	@GetMapping("/api/v1/students")
	public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable){
		
		Page<Student> students = studentService.getAllStudents(pageable);
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/api/v1/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/api/v1/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student) {
		
		Student updatedStudent = studentService.updateStudent(id,student);
		return ResponseEntity.ok( updatedStudent);
	}
	
	@DeleteMapping("/api/v1/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		
		studentService.deleteStudent(id);
		
		return ResponseEntity.noContent().build();
	}
}

