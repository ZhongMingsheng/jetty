package zms.study.cmcc;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.w3c.dom.Document;

public class CrawlCMCC {
@Test
public void getData() throws Exception{
	//创建httpclient实例
	CloseableHttpClient httpClient=HttpClients.createDefault();
	HttpPost doPost=new HttpPost("http://gd.10086.cn/my/REALTIME_LIST_SEARCH_GOTONE.shtml?uniqueTag=20171122153847877");
	List<NameValuePair> parameters=new ArrayList<NameValuePair>();
	parameters.add(new MVP("mobile","13922867756"));
	parameters.add(new MVP("smsPwd", "678388"));
	parameters.add(new MVP("loginType", "1"));
	parameters.add(new MVP("cookieMobile", "on"));
	parameters.add(new MVP("backURL", "http://gd.10086.cn/commodity/index.shtml"));
	UrlEncodedFormEntity entity=new UrlEncodedFormEntity(parameters, "utf-8");
	//doPost.setEntity(entity);
	CloseableHttpResponse response=httpClient.execute(doPost);
	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	DocumentBuilder db=dbf.newDocumentBuilder();
	InputStream is=response.getEntity().getContent();
	//Document document = db.parse(is);
	//document.getElementsByTagName("");
	byte[] b=new byte[1024];
	int len=0;
	while((len=is.read(b))!=-1){
		System.out.println(new String(b,0,len));
	}
}
}
class MVP implements NameValuePair{
	private String name;
	private String value;
	public MVP (){
	}
	public MVP (String name,String value){
		this.name=name;
		this.value=value;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setValue(String value){
		this.value=value;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}}
