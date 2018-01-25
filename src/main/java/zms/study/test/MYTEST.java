package zms.study.test;

import java.math.BigDecimal;

import org.junit.Test;

public class MYTEST {
	private Integer integer;
	public static void main(String[] args) {
		BigDecimal aBigDecimal=new BigDecimal(3);
		BigDecimal bigDecimal=new BigDecimal(6);
		System.out.println(aBigDecimal.compareTo(bigDecimal));
		System.out.println(aBigDecimal.compareTo(aBigDecimal));
		System.out.println(!"1".equalsIgnoreCase(null));
	}
	@Test
	public void test1(){//test nullpointor
		
		if(new Integer(1).equals(integer)){
			System.out.println("1");
		}else{
			System.out.println("0");
		}
	}
}
