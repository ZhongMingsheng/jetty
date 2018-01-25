package zms.study.annotation;

import org.junit.Test;

public class TestAnnotation {
	@Test
	public void test1(){
		String classname = "zms.study.annotation.TestAnnotation";
		TestAnnotation.testAnnotation(classname);
		
	}
	/**
	 * 
	 *
	 *@since 2018年1月18日 下午5:09:00
	 */
	public static void testAnnotation(String classname){
		try {
			Class<?> forName = Class.forName(classname);
			forName.getSimpleName();
			TestAnnotation instance = (TestAnnotation) ResolverAnnotationUtils.getInstance(forName);
			System.out.println(instance.getColor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@BaseAnnotation(color ="hello" )
	private String color;
	public String getColor(){
		return this.color;
	}
}
