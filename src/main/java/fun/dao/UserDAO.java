package fun.dao;

import java.util.Collection;

import fun.exception.BusinessException;
import fun.model.User;

public interface UserDAO {

	public Collection selectAll() throws BusinessException;
	
	public void insertUser(User user) throws BusinessException;
	
	public User selectById(int id) throws BusinessException;
}
