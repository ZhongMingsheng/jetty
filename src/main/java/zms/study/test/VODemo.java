package zms.study.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VODemo {
	@PostMapping("/vo")
	@ResponseBody
	public String testVO(String a,String b){
		return a+b;
	}
}
