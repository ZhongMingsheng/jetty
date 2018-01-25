package zms.study.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zms.study.spring.bean.Student;

public class TestIOC {
	@SuppressWarnings("resource")
	public static ApplicationContext getIOC(String configLocation) {
		return new ClassPathXmlApplicationContext(configLocation);
	}

	@Test
	public void test() {
		ApplicationContext ioc = TestIOC.getIOC("spring-servlet.xml");
		// System.out.println((Student) ioc.getBean("student"));
		// System.out.println((Student) ioc.getBean("student1"));
		System.out.println((ioc.getBean("student")).hashCode());
		System.out.println(ioc.getBean("student1").hashCode());
		System.out.println(ioc.getBean("student").hashCode());
	}
}
