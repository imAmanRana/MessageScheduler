/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.utils;

import java.time.LocalDateTime;
import java.util.Objects;

import com.iqvia.homeassignment.messagescheduler.exceptionHandler.EmptyMessageException;
import com.iqvia.homeassignment.messagescheduler.exceptionHandler.PastDeliveryDateMessage;
import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;

/**
 * Utility Method class
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public class MessageSchedulerUtils {

	/**
	 * Validates the input parameters.
	 * <ul>
	 * <li>Request can't be null</li>
	 * <li>Request message can't be null or empty</li>
	 * <li>Request delivery time should be in the future</li>
	 * </ul>
	 * 
	 * @param request input request
	 * @throws RuntimeException if input validation fails
	 */
	public static void validateInputParameters(final MessageRequest request) {

		if (Objects.isNull(request)) {
			throw new RuntimeException("Invalid Message");
		} else if (Objects.isNull(request.getContent()) || request.getContent().trim().isEmpty()) {
			throw new EmptyMessageException("Empty Content");
		} else if (Objects.isNull(request.getDeliveryTime())
				|| request.getDeliveryTime().isBefore(LocalDateTime.now())) {
			throw new PastDeliveryDateMessage("Delivery Time should not be in past");
		}

	}
}
