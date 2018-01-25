package zms.study.annotation;

import org.springframework.web.servlet.ModelAndView;

//@Controller
/*@RequestMapping("/anno")*/
public class ExtendsAnnoDemo implements Annoable {
	/* @RequestMapping("/hello") */
	@Override
	public ModelAndView sayHello() {
		System.out.println("hello everyone!");
		return new ModelAndView().addObject("aaa", "hello");
	}

}
