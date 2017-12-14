package zms.study.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class MyJobDetail {
public void getJobDetail(){
	JobDetail jobDetail=JobBuilder.newJob(MyJob.class).withDescription("this is first demo").withIdentity("jobName", "groupName").build();
	
}
}
