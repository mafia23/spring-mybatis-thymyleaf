package fun.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fun.exception.BusinessException;
import fun.model.User;
import fun.service.UserService;
import fun.util.SysConf;

@Controller
public class HomeController {
	
	private static Logger logger = Logger.getLogger(HomeController.class.getName());  

	@Autowired
	private SysConf sysConf;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/","/index","index.html"})
	public String index() throws BusinessException{
		return "/common/login";
	}
	
	@RequestMapping({"/user"})
	public ModelAndView userlist() throws BusinessException{
		try{
			ModelAndView mav = new ModelAndView("/modules/user/userList");
			mav.addObject("_master",true);
			List<User> users = userService.getAll();
			mav.addObject("result", users);
			logger.info("================="+sysConf.getTheme()+"===============");
			logger.info("controller....");
			return mav;
		}catch(Exception e){
			throw new BusinessException("300", e.getMessage());
		}
	}
	
	@RequestMapping({"/test"})
	public String test() throws BusinessException{
		return "/common/error/500";
	}
	
	@RequestMapping({"/testep"})
	public String testep() throws BusinessException{
		throw new BusinessException("exception");
		//return "/common/error/500";
	}
	
	@RequestMapping(method=RequestMethod.GET,value={"/login"})
	public String login() throws BusinessException{
		return "/common/login";
	}
	
	@RequestMapping(method=RequestMethod.POST,value={"/login"})
	public ModelAndView dologin2(@RequestParam("username") Integer name, @RequestParam("password") String psd) throws BusinessException{
		//验证
		ModelAndView mav = new ModelAndView();
		if(name==null || psd == null){
			mav.setViewName("/common/login");
			mav.addObject("msg","用户名密码必填");
			return mav;
		}
		User user = userService.getUserById(name);
		if(user==null || !user.getPsd().equals(psd)){//error
			mav.setViewName("/common/login");
			mav.addObject("msg","用户名密码错误");
		}else{
			mav.addObject("user",user);
			mav.addObject("_master",true);
			mav.setViewName("/modules/index");
		}
		
		return mav;
		
	}
	
	
}
