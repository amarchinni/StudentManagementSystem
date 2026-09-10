package student_management_system.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import student_management_system.entity.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	
	Page<Student> getAllStudents(Pageable pageable);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Long id, Student student);
	
	void deleteStudent(Long id);
	
	
	
	

}
