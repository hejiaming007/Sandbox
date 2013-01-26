package spring.ioc.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AnnotationedStudent {
	@Value( "${name}" )
	private String username;
	
	
	
	public String getUsername() {
		return username;
	}
	
}
