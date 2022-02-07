package in.co.school.directory.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import in.co.school.directory.dto.SchoolDTO;


public interface SchoolDAOInt {

	public long add(SchoolDTO bean);
	
	public void update(SchoolDTO bean);
	
	public void delete(SchoolDTO bean);
	
	public SchoolDTO findByName(String name);
	
	public SchoolDTO findByCode(String code);
	
	public SchoolDTO findByPk(long id);
	
	public List<SchoolDTO> search(SchoolDTO bean, long pageNo, int pageSize);
	
	public List<SchoolDTO> search(SchoolDTO bean);
	
	public Blob getImageById(long id) throws SerialException, SQLException;
	
	public Blob getLogoById(long id) throws SerialException, SQLException;
	
}
