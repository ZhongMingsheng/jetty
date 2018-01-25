package zms.study.spring.bean;

public class Student implements Person {
	private String name;
	private String school;
	private Integer age;

	public Student(String name, String school, Integer age) {
		this.name = name;
		this.school = school;
		this.age = age;
	}

	public Student() {
	}

	@Override
	public void say() {
		System.out.println("i'm a student");
	}

	@Override
	public void action() {
		System.out.println("i have many actions");
	}

	@Override
	public void think() {
		System.out.println("i am thinking");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", school=" + school + ", age=" + age
				+ "]";
	}

}
