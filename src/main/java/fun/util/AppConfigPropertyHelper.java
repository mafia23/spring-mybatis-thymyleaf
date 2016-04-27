package fun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <code>{@link AppConfigPropertyHelper}</code>
 *
 * TODO : 应用配置属性获取的类，实现listener接口，web应用启动的时候初始话，
 * 取出里面属性文件的值，在应用中使用
 *
 * @author fun
 */
public class AppConfigPropertyHelper implements ServletContextListener {
	
	Logger logger = LoggerFactory.getLogger(AppConfigPropertyHelper.class);

	private static Map<String,Properties> props = new HashMap<String,Properties>();
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO implement ServletContextListener.contextDestroyed
		props.clear();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//arg0作为配置文件路径名，多个文件用','隔开
		ServletContext context = arg0.getServletContext();
		String propPaths = context.getInitParameter("appConfigPropPath").toString();//获取用户定义的web应用的路径
		System.out.println("=============================="+propPaths+"=============================");
		  
        //通过类加载目录getClassLoader()加载属性文件  
        InputStream in = AppConfigPropertyHelper.class.getClassLoader()  
                .getResourceAsStream(propPaths.substring(propPaths.lastIndexOf(":")+1));  
        Properties prop = new Properties();  
        try {  
            prop.load(in);  
        } catch (IOException e) {  
            logger.error("读取配置文件出错");  
            e.printStackTrace();  
        }
        String propName = propPaths.contains("/") ? propPaths.substring(propPaths.lastIndexOf("/")+1,propPaths.lastIndexOf(".")):
        	propPaths.substring(propPaths.lastIndexOf(":")+1,propPaths.lastIndexOf("."));
        System.out.println(propName+"===================");
        AppConfigPropertyHelper.props.put(propName, prop);
        System.out.println("listent init ok======================");
        System.out.println("Map props="+AppConfigPropertyHelper.getProps());
		
	}
	
	/**
	 * 获取属性值
	 * @param propName
	 * @param key
	 * @return
	 */
	public static String getPropertyByName(String propName,String key){
		Map<String, Properties> m = AppConfigPropertyHelper.getProps();
		Properties p = (Properties)m.get(propName);
		if(p == null){
			return null;
		}else{
			return p.getProperty(key);
		}
	}

	/**
	 * @return the props
	 */
	private static Map<String, Properties> getProps() {
		return AppConfigPropertyHelper.props;
	}

}
