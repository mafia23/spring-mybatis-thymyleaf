package fun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyHelper {
	private static Logger logger = LoggerFactory.getLogger(PropertyHelper.class);
	private static Properties property=null;
	
	private static Properties initProperty(){
		InputStream in = PropertyHelper.class.getClassLoader()  
                .getResourceAsStream("config/sysconf.properties");  
		property = new Properties();
		try {
			property.load(in);
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return property;
	}
	synchronized public static String getProperty(String key){
		if(property == null){
			property = initProperty();
		}
		return property.getProperty(key);
	}
	
	
}
