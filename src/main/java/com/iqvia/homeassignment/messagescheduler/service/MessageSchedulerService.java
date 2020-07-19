/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.service;

import org.quartz.SchedulerException;

import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;
import com.iqvia.homeassignment.messagescheduler.model.MessageResponse;

/**
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target="_blank">LinkedIn Profile</a>
 */
public interface MessageSchedulerService {

	
	MessageResponse scheduleMessage(MessageRequest messageRequest) throws SchedulerException;
}
