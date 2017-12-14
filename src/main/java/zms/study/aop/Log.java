package zms.study.aop;


public class Log {
	public void dobefore(){
		System.out.println("boss come in");
	}
	public void doafter(){
		System.out.println("boss after");
	}
	public void dothrow(){
		System.out.println("boss throw");
	}
	public void doreturn(){
		System.out.println("boss return");
	}
	public void doaround(){
		System.out.println("boss around");
	}
}
