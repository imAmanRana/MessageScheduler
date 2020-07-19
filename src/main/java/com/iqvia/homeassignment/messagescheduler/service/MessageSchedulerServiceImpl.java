/**
 * IQVIA - Home Assignment
 */
package com.iqvia.homeassignment.messagescheduler.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqvia.homeassignment.messagescheduler.job.MessagePrintJob;
import com.iqvia.homeassignment.messagescheduler.model.MessageRequest;
import com.iqvia.homeassignment.messagescheduler.model.MessageResponse;
import com.iqvia.homeassignment.messagescheduler.utils.MessageSchedulerConstants;

/**
 * Implementation class for Message Scheduler
 * 
 * @author Amandeep Singh
 * @see <a href="https://www.linkedin.com/in/imamanrana/" target=
 *      "_blank">LinkedIn Profile</a>
 */
@Service
public class MessageSchedulerServiceImpl implements MessageSchedulerService {

	@Autowired
	private Scheduler scheduler;

	@Override
	public MessageResponse scheduleMessage(MessageRequest messageRequest) throws SchedulerException {

		JobDetail jobDetail = buildJobDetail(messageRequest);
		Trigger trigger = buildJobTrigger(jobDetail, messageRequest.getDeliveryTime());
		Date scheduledTime = scheduler.scheduleJob(jobDetail, trigger);
		
		if (Objects.isNull(scheduledTime)) {
			throw new SchedulerException("Internal service Error");
		}

		return new MessageResponse(true,
				String.format("%s scheduled for %t", messageRequest.getContent(), scheduledTime));
	}

	/**
	 * Creates a new Quartz Scheduler Job
	 * 
	 * @param messageRequest
	 * @return scheduler job
	 */
	private JobDetail buildJobDetail(MessageRequest messageRequest) {
		JobDataMap jobDataMap = new JobDataMap();

		jobDataMap.put(MessageSchedulerConstants.CONTENT, messageRequest.getContent());
		jobDataMap.put(MessageSchedulerConstants.DELIVERY_TIME, messageRequest.getDeliveryTime());

		return JobBuilder.newJob(MessagePrintJob.class).withIdentity(UUID.randomUUID().toString(), "print-job")
				.withDescription("Print Message to Console").usingJobData(jobDataMap).requestRecovery().storeDurably()
				.build();
	}

	/**
	 * Creates a trigger at specific time for a job
	 * 
	 * @param jobDetail
	 * @param startAt
	 * @return scheduler trigger
	 */
	private Trigger buildJobTrigger(JobDetail jobDetail, LocalDateTime startAt) {
		return TriggerBuilder.newTrigger().forJob(jobDetail).withIdentity(jobDetail.getKey().getName(), "print-trigger")
				.withDescription("Print Message Trigger")
				.startAt(Date.from(startAt.atZone(ZoneId.systemDefault()).toInstant()))
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow()).build();
	}

}
