package student_management_system.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
      
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String,String>> handleStudentNotFoundException(StudentNotFoundException ex){
		   
		Map<String, String> response = new HashMap<>();
		
		response.put("message",ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		    
		}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationErrors(MethodArgumentNotValidException ex){
		
		Map<String,String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.collect(Collectors.toMap( error -> error.getField(),
						                   error -> error.getDefaultMessage()));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
		
	}
	
	
}
