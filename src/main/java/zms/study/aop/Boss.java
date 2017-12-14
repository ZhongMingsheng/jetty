package zms.study.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zms.study.bean.ResultDt;

@Controller
public class Boss {
	// @GetMapping("/hello")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public ResultDt<Void> hello() {
		ResultDt<Void> result = new ResultDt<Void>();
		result.code = "1";
		result.setTotal(0);
		System.out.println("start");
		say();
		System.out.println("end");
		return result;
	}

	public void say() {
		System.out.println("i'm say function");
		Object str = null;
		System.out.println(str.hashCode());
	}
}
