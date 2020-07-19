/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;
import com.iqvia.homeassignment.messagescheduler.model.MessageResponse;
import com.iqvia.homeassignment.messagescheduler.service.MessageSchedulerService;
import com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils;

/**
 * RESTful web service which schedules messages to be printed at specific time.
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
@RestController
public class MessageSchedulerController {

	@Autowired
	MessageSchedulerService service;

	@RequestMapping(value = "/schedulemessage", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> scheduleMessage(@RequestBody MessageRequest message)
			throws SchedulerException {

		MessageSchedulerUtils.validateInputParameters(message);

		return new ResponseEntity<MessageResponse>(service.scheduleMessage(message), HttpStatus.ACCEPTED);
	}

	/*
	 * ALL OTHER HTTP METHODS NOT ALLOWED
	 */

	@RequestMapping(value = "/schedulemessage", method = RequestMethod.GET)
	public ResponseEntity<Object> getScheduledMessage() {
		return new ResponseEntity<Object>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@RequestMapping(value = "/schedulemessage", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteScheduledMessage() {
		return new ResponseEntity<Object>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}

	@RequestMapping(value = "/schedulemessage", method = RequestMethod.PUT)
	public ResponseEntity<Object> createScheduleMessage() {
		return new ResponseEntity<Object>(null, HttpStatus.METHOD_NOT_ALLOWED);
	}
}
