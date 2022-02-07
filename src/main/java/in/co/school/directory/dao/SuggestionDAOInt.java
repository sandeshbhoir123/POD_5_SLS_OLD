package in.co.school.directory.dao;

import java.util.List;


import in.co.school.directory.dto.SuggestionDTO;


public interface SuggestionDAOInt {

	public long add(SuggestionDTO bean);
	
	public void update(SuggestionDTO bean);
	
	public void delete(SuggestionDTO bean);
	
	public SuggestionDTO findByName(String name);
	
	public SuggestionDTO findByCode(String code);
	
	public SuggestionDTO findByPk(long id);
	
	public List<SuggestionDTO> search(SuggestionDTO bean, long pageNo, int pageSize);
	
	public List<SuggestionDTO> search(SuggestionDTO bean);
	
}
