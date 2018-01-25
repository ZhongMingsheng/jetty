package zms.study.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anno")
public interface Annoable {
	@RequestMapping("/hello")
	@ResponseBody
	public ModelAndView sayHello();
}
