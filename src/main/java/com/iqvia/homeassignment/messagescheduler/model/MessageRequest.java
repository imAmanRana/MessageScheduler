/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.model;

import java.time.LocalDateTime;

/**
 * Model Class for input request
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public class MessageRequest {

	
	private String content;

	private LocalDateTime deliveryTime;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the deliveryTime
	 */
	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
}
