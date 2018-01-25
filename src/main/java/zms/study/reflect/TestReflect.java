package zms.study.reflect;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestReflect {
	private static Map<String, Class> classMap = new HashMap<String, Class>();
	/**
	 * param classPath 是路径形式的包名，如：zms/study/annotation
	 *
	 *@since 2018年1月19日 上午9:54:00
	 */
	public static Map<String, Class> getAllClass(String classPath) throws Exception{
		String filePath = System.getProperty("user.dir")+"/src/main/java/"+classPath;
		File file = new File(filePath);
		File[] listFiles = file.listFiles();
		String fileName = "";
		for (File file2 : listFiles) {
			fileName = file2.getName();
			if(fileName != "" && fileName != null){
				classMap.put(fileName.split("\\.")[0], Class.forName(classPath.replace("/", ".")+"."+fileName.split("\\.")[0]));
			}
		}
		return classMap;
	}
	@Test
	public void test(){
		//System.out.println(System.getProperty("user.dir"));
		//System.out.println(TestReflect.class.getClass().getResource("/").getPath());
		String filePath ="zms/study/annotation";
		try {
			TestReflect.getAllClass(filePath);
			/*if(classMap != null){
				Set<Entry<String,Class>> entrySet = classMap.entrySet();
				Iterator<Entry<String, Class>> iterator = entrySet.iterator();
				while(iterator.hasNext()){
					Entry<String, Class> entry = iterator.next();
					System.out.println(entry.getKey()+"======="+entry.getValue());
				}
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
