/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.model;

/**
 * Model Class for response
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public class MessageResponse {

	private boolean success;
	private String message;

	public MessageResponse(final boolean success, final String message) {
		this.success = success;
		this.message = message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
