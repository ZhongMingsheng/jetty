package zms.study.jackson;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zms.study.bean.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class JacksonDemo {
	@ResponseBody
	@PostMapping("/tojackson")
	public ResultDt<Student> toJackson(HttpServletRequest request){
		ResultDt<Student> result=new ResultDt<Student>();
		try{
			if("post".equalsIgnoreCase(request.getMethod())){
				int length=request.getContentLength();
				if(length<=0){
					result.code="1";
					return result;
				}
				byte[] b=new byte[length];
				request.getInputStream().read(b);
				Student st=new ObjectMapper().readValue(new String(b, request.getCharacterEncoding()), Student.class);
				result.setRows(st);
				result.code="0";
			}
		}catch(Exception e){
			e.getMessage();
		}
		return result;
	}
}
