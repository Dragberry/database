package by.bsuir.drahun.database.client.context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.bsuir.drahun.database.application.SpringConfiguration;

public final class ContextProvider {

	private static ConfigurableApplicationContext context;
	
	private ContextProvider() {
	}
	
	public static ConfigurableApplicationContext getContext() {
		if (context == null) {
			context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		} 
		return context;
	}
	
}
