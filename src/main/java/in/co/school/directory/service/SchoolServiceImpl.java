package in.co.school.directory.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.school.directory.dao.SchoolDAOInt;
import in.co.school.directory.dto.SchoolDTO;
import in.co.school.directory.exception.DuplicateRecordException;


@Service
public class SchoolServiceImpl implements SchoolServiceInt {
	
	private Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	private SchoolDAOInt dao;
	
	@Override
	@Transactional
	public long add(SchoolDTO bean) throws DuplicateRecordException {
		log.info("SchoolServiceImpl  add method start");
		SchoolDTO existDTO = dao.findByName(bean.getName());
		if (existDTO != null) {
			throw new DuplicateRecordException("School Name already Exist");
		}
		long pk = dao.add(bean);
		log.info("SchoolServiceImpl add method end");
		return pk;
	}

	@Override
	@Transactional
	public void update(SchoolDTO bean) throws DuplicateRecordException {
		log.info("SchoolServiceImpl  update method start");
		SchoolDTO existDTO = dao.findByName(bean.getName());
		if (existDTO != null && existDTO.getId() != bean.getId()) {
			throw new DuplicateRecordException("School Name already Exist");
		}
		dao.update(bean);
		log.info("SchoolServiceImpl update method end");
		
	}

	@Override
	@Transactional
	public void delete(SchoolDTO bean) {
		log.info("SchoolServiceImpl  delete method start");
		dao.delete(bean);
		log.info("SchoolServiceImpl delete method end");
		
	}

	@Override
	@Transactional
	public SchoolDTO findByName(String name) {
		log.info("SchoolServiceImpl  findByLogin method start");
		SchoolDTO bean = dao.findByName(name);
		log.info("SchoolServiceImpl findByLogin method end");
		return bean;
	}

	@Override
	@Transactional
	public SchoolDTO findByCode(String code) {
		log.info("SchoolServiceImpl  findByCode method start");
		SchoolDTO bean = dao.findByCode(code);
		log.info("SchoolServiceImpl findByCode method end");
		return bean;
	}

	@Override
	@Transactional
	public SchoolDTO findByPk(long id) {
		log.info("SchoolServiceImpl  findByPk method start");
		SchoolDTO bean = dao.findByPk(id);
		log.info("SchoolServiceImpl findBypk method end");
		return bean;
	}

	@Override
	@Transactional
	public List<SchoolDTO> search(SchoolDTO bean, long pageNo, int pageSize) {
		log.info("SchoolServiceImpl  search method start");
		List<SchoolDTO> list = dao.search(bean, pageNo, pageSize);
		log.info("SchoolServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public List<SchoolDTO> search(SchoolDTO bean) {
		log.info("SchoolServiceImpl  search method start");
		List<SchoolDTO> list = dao.search(bean);
		log.info("SchoolServiceImpl search method end");
		return list;
	}

	@Override
	@Transactional
	public Blob getImageById(long id) throws SerialException, SQLException {
		return dao.getImageById(id);
	}

	@Override
	@Transactional
	public Blob getLogoById(long id) throws SerialException, SQLException {
		return dao.getLogoById(id);
	}

}
