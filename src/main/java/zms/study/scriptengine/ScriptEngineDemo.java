package zms.study.scriptengine;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
public class ScriptEngineDemo {
	public static void main(String[] args) {
		try {
			greet();
		} catch (Exception e) {
		}
	}

	public static void greet() throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		// ScriptEngine engine = manager.getEngineByExtension("js");
		// ScriptEngine engine = manager.getEngineByMimeType("text/javascript");
		System.out.println(engine);
		if (engine == null) {
			throw new RuntimeException("找不到JavaScript语言执行引擎。");
		}
		FileReader fr=new FileReader("C:\\Users\\king\\Desktop\\JavaScript.js");
		BufferedReader br=new BufferedReader(fr);
		String str="";
		while((str=br.readLine())!=null){
			System.out.println(str);
			engine.eval(str);
		}
		br.close();
		fr.close();
		engine.eval("println('Hello!');");
	}
}
