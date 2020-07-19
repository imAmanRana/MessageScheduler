/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.iqvia.homeassignment.messagescheduler.exceptionHandler.EmptyMessageException;
import com.iqvia.homeassignment.messagescheduler.exceptionHandler.PastDeliveryDateMessage;
import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;

/**
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
class MessageSchedulerUtilsTest {

	MessageRequest request;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		request = new MessageRequest();
		request.setContent("Test Message");
		request.setDeliveryTime(LocalDateTime.now());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		request = null;
	}

	/**
	 * Test method for null input
	 * {@link com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils#validateInputParameters(com.iqvia.homeassignment.messagescheduler.model.MessageRequest)}.
	 */
	@Test
	void testValidateInputParameters_nullInput() {
		request = null;
		assertThrows(RuntimeException.class, () -> {
			MessageSchedulerUtils.validateInputParameters(request);
		});
	}

	/**
	 * Test method for null message
	 * {@link com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils#validateInputParameters(com.iqvia.homeassignment.messagescheduler.model.MessageRequest)}.
	 */
	@Test
	void testValidateInputParameters_MesageNull() {
		request.setContent(null);
		assertThrows(EmptyMessageException.class, () -> {
			MessageSchedulerUtils.validateInputParameters(request);
		});
	}

	/**
	 * Test method for empty input
	 * {@link com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils#validateInputParameters(com.iqvia.homeassignment.messagescheduler.model.MessageRequest)}.
	 */
	@Test
	void testValidateInputParameters_MesageEmpty() {
		request.setContent("");
		assertThrows(EmptyMessageException.class, () -> {
			MessageSchedulerUtils.validateInputParameters(request);
		});
	}
	
	/**
	 * Test method for null delivery
	 * {@link com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils#validateInputParameters(com.iqvia.homeassignment.messagescheduler.model.MessageRequest)}.
	 */
	@Test
	void testValidateInputParameters_DeliveryTimeNull() {
		request.setDeliveryTime(null);
		assertThrows(PastDeliveryDateMessage.class, () -> {
			MessageSchedulerUtils.validateInputParameters(request);
		});
	}
	
	/**
	 * Test method for empty input
	 * {@link com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerUtils#validateInputParameters(com.iqvia.homeassignment.messagescheduler.model.MessageRequest)}.
	 */
	@Test
	void testValidateInputParameters_PastDeliveryTime() {
		request.setDeliveryTime(request.getDeliveryTime().minusDays(1));
		assertThrows(PastDeliveryDateMessage.class, () -> {
			MessageSchedulerUtils.validateInputParameters(request);
		});
	}

}
