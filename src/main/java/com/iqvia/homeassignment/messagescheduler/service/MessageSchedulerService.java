/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.service;

import org.quartz.SchedulerException;

import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;
import com.iqvia.homeassignment.messagescheduler.model.MessageResponse;

/**
 * Service class interface
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public interface MessageSchedulerService {

	/**
	 * Message Scheduler
	 * 
	 * @param messageRequest
	 * @return {@link MessageResponse}
	 * @throws SchedulerException
	 */
	MessageResponse scheduleMessage(final MessageRequest messageRequest) throws SchedulerException;
}
