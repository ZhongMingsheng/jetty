package zms.study.weather;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class WeatherAPI {
	@Test
public void test1() throws Exception{
	URL url=new URL("http://www.weather.com.cn/data/cityinfo/101180601.html");
	URLConnection connection=url.openConnection();
	connection.connect();
	BufferedReader inputStream=new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String line=null;
	StringBuilder result=new StringBuilder();
	while((line=inputStream.readLine())!=null){
		result.append(line);
	}
	
	System.out.println(result);
}
}
