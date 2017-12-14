package zms.study.test;

import java.math.BigDecimal;
import java.util.Date;

public class TestDemo {
public static void main(String[] args) throws Exception {
	/*BigDecimal bd=new BigDecimal(0);
	for(int i=0;i<4;i++){
		bd=bd.add(new BigDecimal(i));
		System.out.println(bd);
	}*/
//	int code = (int) ((Math.random() * 9 + 1) * 100000);
	Date d1=new Date();
	System.out.println(d1);
	Thread.sleep(2100);
	Date d2=new Date();
	System.out.println(d2);
	boolean flag=(d2.getTime()-d1.getTime())/1000>1;
	System.out.println((d2.getTime()-d1.getTime())/1000);
	System.out.println(flag);
}
}
