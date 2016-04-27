package fun.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fun.model.User;
import fun.service.UserService;
import fun.util.PropertyHelper;

public class MyTest {

	private ApplicationContext axc;

	@Test
	public void test(){
		System.out.println("test............");
		axc = new ClassPathXmlApplicationContext("spring/*.xml");
		UserService userService = axc.getBean(UserService.class);
		
		List<User> users = userService.getAll();
		for(User user :users){
			System.out.println("id="+user.getId()+"\tname="+user.getName()+"\tpsd="+user.getPsd());
		}
	}
	
	@Test
	public void testLog(){
		 PropertyConfigurator.configure("G:/02-coding/spring_myBatis_Thymeleaf/src/main/resources/config/log4j.properties");
	     Logger logger  =  Logger.getLogger(MyTest.class);
	     logger.debug( " debug " );
	     logger.error( " error " );
	     logger.debug("test");
	}
	
	@Test
	public void testAppConfigProperty(){
		String theme = PropertyHelper.getProperty("sysconf.theme");
		System.out.println(theme);
	}
	
	public static void main(String[] args) {
		String theme = PropertyHelper.getProperty("sysconf.theme");
		System.out.println(theme);
	}
}
