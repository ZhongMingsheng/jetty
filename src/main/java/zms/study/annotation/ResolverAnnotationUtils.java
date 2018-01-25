package zms.study.annotation;

import java.lang.reflect.Field;

public class ResolverAnnotationUtils {
	public static <T> T getInstance(Class<T> clazz) throws Exception{
		T instance = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			//判断该字段是否被传入的注解所注解
			if(field.isAnnotationPresent(BaseAnnotation.class)){
				//忽略java语言检查
				field.setAccessible(true);
				//将注解的值赋值给对应的字段
				field.set(instance, field.getAnnotation(BaseAnnotation.class).color());
			}
			
		}
		return instance;
	}
}
