package fun.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import fun.util.AppConfigPropertyHelper;
import fun.util.SysConf;

public class LocalInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private SysConf sysConf;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		
		/**
		 * 设置环境变量
		 */
		System.out.println(sysConf.getTheme());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%"+AppConfigPropertyHelper.getPropertyByName("sysconf", "sysconf.theme"));
		System.out.println(modelAndView);
		if(modelAndView != null){
			String realViewName = modelAndView.getViewName();
			if(modelAndView.getModelMap().get("_master") != null){
				System.out.println(modelAndView.getModelMap().get("_master"));
				boolean _master = Boolean.valueOf(modelAndView.getModelMap().get("_master").toString());
				if(_master){
					modelAndView.setViewName("/common/master");
					modelAndView.addObject("contentName",realViewName);
				}
			}
			modelAndView.addObject("theme",sysConf.getTheme());
			modelAndView.addObject("ctx",request.getContextPath());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	

}
