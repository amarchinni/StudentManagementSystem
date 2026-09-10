package student_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import student_management_system.entity.Student;
import student_management_system.exception.StudentNotFoundException;
import student_management_system.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
	
		return studentRepository.save(student);
	}

	@Override
	public Page<Student> getAllStudents(Pageable pageable) {
		
		return studentRepository.findAll(pageable);
	}

	@Override
	public Student getStudentById(Long id) {
	    return studentRepository.findById(id)
	            .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
	}
	@Override
	public Student updateStudent(Long id, Student student) {
		
		Student  existingStudent =  studentRepository.findById(id).orElse(null) ;	
		
		if(existingStudent  != null) {
			existingStudent.setName(student.getName());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setPhone(student.getPhone());
			existingStudent.setCourse(student.getCourse());
			   
			return studentRepository.save(existingStudent);
		}
		
		return null;	
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.deleteById(id);
		
	}
}
