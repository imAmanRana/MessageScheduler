/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Job to print scheduled messages to console
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
public class MessagePrintJob extends QuartzJobBean {

	private static final Logger logger = LoggerFactory.getLogger(MessagePrintJob.class);

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Executing Job with key {}", context.getJobDetail().getKey());

		JobDataMap jobDataMap = context.getMergedJobDataMap();

		System.out.println(jobDataMap.get("content"));

	}

}
