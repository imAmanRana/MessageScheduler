/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;
import com.iqvia.homeassignment.messagescheduler.model.MessageResponse;
import com.iqvia.homeassignment.messagescheduler.service.MessageSchedulerService;

/**
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
@RestController
public class MessageSchedulerController {

	@Autowired
	MessageSchedulerService service;

	@RequestMapping(value = "/schedulemessage", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> scheduleMessage(@RequestBody MessageRequest message)
			throws SchedulerException {
		return new ResponseEntity<MessageResponse>(service.scheduleMessage(message), HttpStatus.ACCEPTED);
	}
}
