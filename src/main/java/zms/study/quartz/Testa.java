package zms.study.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.spi.MutableTrigger;

public class Testa {
	@Test
	public void test2() throws Exception{
		//调度工厂
		SchedulerFactory sf = new StdSchedulerFactory();
		//调度器
		Scheduler sched = sf.getScheduler();
		//任务
		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
		//触发器
		Trigger trigger = TriggerBuilder.newTrigger().startNow().withIdentity("trigger1", "group1").build();
		//CronTrigger cronTrigger=TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
		sched.scheduleJob(job, trigger);
		sched.start();
		Thread.sleep(300L * 1000L);
		sched.shutdown(true);
	}
	@Test
public void test1(){
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("1", "aaa");
	map.put("1", "bbb");
	//String string="ad dfdf df ";
	//System.out.println(string.replaceAll(" ", ""));addfdfdf
	//map.forEach(("a","ddd")->{});
	String string="aaaddd";
	string.replaceAll("ddd", "aaa");
	System.out.println(string);
	List<String> list=new ArrayList<String>();
	List<String> list1=new ArrayList<String>();
	list.add(null);
	list1.add("a");
	list1.add("b");
	if(list==null){
		System.out.println("list is null");
	}
	list.addAll(list1);
	if(list==null){
		System.out.println("list is null");
	}else {
		System.out.println(list);
	}
	ScheduleBuilder<Trigger> scheduleBuilder=new ScheduleBuilder<Trigger>() {

		@Override
		protected MutableTrigger build() {
			
			return null;
		}
	};
}
}

