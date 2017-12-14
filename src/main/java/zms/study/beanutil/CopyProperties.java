package zms.study.beanutil;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;

public class CopyProperties {
public static void main(String[] args) throws Exception {
	A a=new A("zhong", null);
	B b=new B(null, 18, '男');
	System.out.println("copy before");
	System.out.println(a);
	System.out.println(b);
	//BeanUtils.copyProperties(a, b);//copy a to b fail
	/*
	copy before
	A [time=zhong, age=null]
	B [time=null, age=18, sex=男]
	copy after
	A [time=zhong, age=null]
	B [time=zhong, age=null, sex=男]
	 * */
	org.springframework.beans.BeanUtils.copyProperties(a, b);//copy a to b success
	System.out.println("copy after");
	System.out.println(a);
	System.out.println(b);
}
}
class A{
	private String time;
	private Integer age;
	
	public A(String time, Integer age) {
		super();
		this.time = time;
		this.age = age;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "A [time=" + time + ", age=" + age + "]";
	}
	
}
class B{
	@Autowired
	private String time;
	private Integer age;
	private char sex;
	public B(String time, Integer age, char sex) {
		super();
		this.time = time;
		this.age = age;
		this.sex = sex;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "B [time=" + time + ", age=" + age + ", sex=" + sex + "]";
	}
	
}
