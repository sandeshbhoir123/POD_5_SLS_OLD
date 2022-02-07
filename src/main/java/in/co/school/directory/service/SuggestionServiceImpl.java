package in.co.school.directory.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.school.directory.dao.SuggestionDAOInt;
import in.co.school.directory.dto.SuggestionDTO;
import in.co.school.directory.exception.DuplicateRecordException;


@Service
public class SuggestionServiceImpl implements SuggestionServiceInt {
	
	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private SuggestionDAOInt dao;
	
	@Override
	@Transactional
	public long add(SuggestionDTO bean) throws DuplicateRecordException {
		log.info("SuggestionServiceImpl  add method start");
		SuggestionDTO existDTO = dao.findByName(bean.getName());
		if (existDTO != null) {
			throw new DuplicateRecordException("Suggestion Name already Exist");
		}
		long pk = dao.add(bean);
		log.info("SuggestionServiceImpl add method end");
		return pk;
	}

	@Override
	@Transactional
	public void update(SuggestionDTO bean) throws DuplicateRecordException {
		log.info("SuggestionServiceImpl  update method start");
		SuggestionDTO existDTO = dao.findByName(bean.getName());
		if (existDTO != null && existDTO.getId() != bean.getId()) {
			throw new DuplicateRecordException("Suggestion Name already Exist");
		}
		dao.update(bean);
		log.info("SuggestionServiceImpl update method end");
		
	}

	@Override
	@Transactional
	public void delete(SuggestionDTO bean) {
		log.info("SuggestionServiceImpl  delete method start");
		dao.delete(bean);
		log.info("SuggestionServiceImpl delete method end");
		
	}

	@Override
	@Transactional
	public SuggestionDTO findByName(String name) {
		log.info("SuggestionServiceImpl  findByLogin method start");
		SuggestionDTO bean = dao.findByName(name);
		log.info("SuggestionServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public SuggestionDTO findByCode(String code) {
		log.info("SuggestionServiceImpl  findByCode method start");
		SuggestionDTO bean = dao.findByCode(code);
		log.info("SuggestionServiceImpl findByCode method end");
		return bean;
	}

	@Override
	@Transactional
	public SuggestionDTO findByPk(long id) {
		log.info("SuggestionServiceImpl  findByPk method start");
		SuggestionDTO bean = dao.findByPk(id);
		log.info("SuggestionServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<SuggestionDTO> search(SuggestionDTO bean, long pageNo, int pageSize) {
		log.info("SuggestionServiceImpl  search method start");
		List<SuggestionDTO> list = dao.search(bean, pageNo, pageSize);
		log.info("SuggestionServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<SuggestionDTO> search(SuggestionDTO bean) {
		log.info("SuggestionServiceImpl  search method start");
		List<SuggestionDTO> list = dao.search(bean);
		log.info("SuggestionServiceImpl search method end");
		return list;
	}

	

}
