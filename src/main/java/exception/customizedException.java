package exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
	public class customizedException extends ResponseEntityExceptionHandler {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
	Errors exceptionresponse=new Errors(new Date(),ex.getMessage(),request.getDescription(false));
	
return new ResponseEntity(exceptionresponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
public final ResponseEntity<Object> handleCategoryNotFoundException(ResourceNotFoundException ex, WebRequest request) throws Exception {

		Errors exceptionresponse=new Errors(new Date(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity<Object>(exceptionresponse,HttpStatus.NOT_FOUND);
	


}}



