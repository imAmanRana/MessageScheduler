/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.exceptionHandler;

/**
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public class PastDeliveryDateMessage extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message Exception Message
	 */
	public PastDeliveryDateMessage(final String message) {
		super(message);
	}
}
