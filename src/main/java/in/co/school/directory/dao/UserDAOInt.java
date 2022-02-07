package in.co.school.directory.dao;

import java.util.List;

import in.co.school.directory.dto.UserDTO;


public interface UserDAOInt {

	public long add(UserDTO bean);
	
	public void update(UserDTO bean);
	
	public void delete(UserDTO bean);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO findByPk(long id);
	
	public List<UserDTO> search(UserDTO bean, long pageNo, int pageSize);
	
	public List<UserDTO> search(UserDTO bean);
	
	public UserDTO authenticate(UserDTO bean);
	
}
