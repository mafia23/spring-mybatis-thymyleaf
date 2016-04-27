package fun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.dao.UserDAO;
import fun.exception.BusinessException;
import fun.model.User;
import fun.util.AppConfigPropertyHelper;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public List<User> getAll() throws BusinessException{
		try{
			//测试在service中使用系统配置的变量，成功了，可以使用
			String theme = AppConfigPropertyHelper.getPropertyByName("sysconf", "sysconf.theme");
			System.out.println("####################################"+theme);
			
			return (List<User>)userDAO.selectAll();
		}catch(Exception e){
			e.printStackTrace();
			throw new BusinessException("300",e.getMessage());
		}
	}
	
	public User getUserById(int id) throws BusinessException{
		return userDAO.selectById(id);
	}
	
	public void save(User user) throws BusinessException{
		
	}
}
