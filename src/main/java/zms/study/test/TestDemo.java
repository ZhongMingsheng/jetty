package zms.study.test;

import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

/*class TestDemo {
	public static void main(String[] args) throws Exception {
		
		 * BigDecimal bd=new BigDecimal(0); for(int i=0;i<4;i++){ bd=bd.add(new
		 * BigDecimal(i)); System.out.println(bd); }
		 
		// int code = (int) ((Math.random() * 9 + 1) * 100000);
		Date d1 = new Date();
		System.out.println(d1);
		Thread.sleep(2100);
		Date d2 = new Date();
		System.out.println(d2);
		boolean flag = (d2.getTime() - d1.getTime()) / 1000 > 1;
		System.out.println((d2.getTime() - d1.getTime()) / 1000);
		System.out.println(flag);
		System.out.println("+++++++++++++++++++++++++");
		Person person = new Person();
		
	}
}*/
class Person{
	private String name;

	public String getName() {
		return "bbb";
	}

	public void setName(String name) {
		this.name = name;
	}
	@Test
	public  void test1(){
		
	}
	public static void main(String[] args) {
		BigDecimal aBigDecimal=new BigDecimal(3);
		BigDecimal bigDecimal=new BigDecimal(6);
		System.out.println(aBigDecimal.compareTo(bigDecimal));
		System.out.println(aBigDecimal.compareTo(aBigDecimal));
	}
}
public class TestDemo extends Person{
	@Test
	public void testClient(){
		
	}
	@Test
	public void testServer()throws Exception{
		Server.endServer();
		Client.endClient();
		Server.getServer(new ServerSocket(), new InetSocketAddress(9999));
		Client.getClient(new Socket("localhost", 9999));
		Server.receive();
		Server.send();
		Client.send();
		Client.receive();
		
	}
	@Override
	public String getName() {
		return "aaa";
	}
	@Test
	public void test1(){
		System.out.println((new BigDecimal(100.23)).doubleValue());
		System.out.println(this.getName());
		System.out.println(super.getName());
	}
	/*public static void main(String[] args){
		System.out.println("start");
		Scanner scanner =new Scanner(System.in);
		String string=scanner.next();
		try {
			if("1".equalsIgnoreCase(string)){
				throw new MyException("异常");
			}
			System.out.println("try");
		} catch (Exception e) {
			System.out.println("catch");
		}
		System.out.println("end");
	}*/
}
class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyException(String msg){
		super(msg+"hello");
	}
}
