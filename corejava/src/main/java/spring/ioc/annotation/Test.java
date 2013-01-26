package spring.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("spring.ioc.annotation");
		AnnotationedTeacher teacher = (AnnotationedTeacher)ctx.getBean("annotationedTeacher");
		String name = teacher.getStudent().getUsername();
		System.out.println("Test.main(), name:" + name);
		
	}

}
