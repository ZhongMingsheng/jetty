package zms.study.math;

import org.junit.Test;

public class TestMath {
	@Test
	public void testCeil(){
		//param is positive
		double ceil = Math.ceil(199.1);//200.0
		System.out.println(ceil);
		System.out.println("-----------------");
		//param is negative
		double ceil2 = Math.ceil(-199.4);//-199.0
		System.out.println(ceil2);
	}
}
