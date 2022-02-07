package in.co.school.directory.service;

import java.util.List;

import in.co.school.directory.dto.UserDTO;
import in.co.school.directory.exception.DuplicateRecordException;


public interface UserServiceInt {

	public long add(UserDTO bean) throws DuplicateRecordException;
	
	public void delete(UserDTO bean) ;
	
	public void update(UserDTO bean) throws DuplicateRecordException;
	
	public UserDTO findByPK(long pk) ;
	
	public UserDTO findByLogin(String login) ;
	
	public List<UserDTO> search(UserDTO bean);
	
	public List search(UserDTO bean, int pageNo, int pageSize) ;
	 
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) ;
    
    public UserDTO authenticate(UserDTO bean);

    public long registerUser(UserDTO bean) throws DuplicateRecordException  ;
    
    public boolean forgetPassword(String login);
	
}
