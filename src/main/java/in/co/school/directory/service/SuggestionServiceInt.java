package in.co.school.directory.service;

import java.util.List;

import in.co.school.directory.dto.SuggestionDTO;
import in.co.school.directory.exception.DuplicateRecordException;


public interface SuggestionServiceInt {

public long add( SuggestionDTO bean) throws DuplicateRecordException;
	
	public void update( SuggestionDTO bean) throws DuplicateRecordException;
	
	public void delete( SuggestionDTO bean);
	
	public  SuggestionDTO findByName(String name);
	
	public  SuggestionDTO findByCode(String code);
	
	public  SuggestionDTO findByPk(long id);
	
	public List< SuggestionDTO> search( SuggestionDTO bean, long pageNo, int pageSize);
	
	public List< SuggestionDTO> search( SuggestionDTO bean);
	
	
	
}
