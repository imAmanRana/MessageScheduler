/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.exceptionHandler;

import java.time.format.DateTimeParseException;

import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handler
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
@ControllerAdvice
public class MessageSchedulerExceptionHandler {

	/**
	 * Exception Handler for Scheduler
	 * 
	 * @param exception
	 * @return 500 - INTERNAL SERVER ERROR
	 */
	@ExceptionHandler(value = SchedulerException.class)
	public ResponseEntity<Object> exception(SchedulerException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handles any runtime exception in the application
	 * 
	 * @param exception
	 * @return 400 - BAD REQUEST
	 */
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> exception(RuntimeException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Handles date parsing exception in the application
	 * 
	 * @param exception
	 * @return 400 - BAD REQUEST
	 */
	@ExceptionHandler(value = DateTimeParseException.class)
	public ResponseEntity<Object> exception(DateTimeParseException exception) {
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
}
