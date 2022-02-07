package in.co.school.directory.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.school.directory.dto.SchoolDTO;

@Repository
public class SchoolDAOImpl implements SchoolDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(SchoolDTO bean) {
		log.info("SchoolDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("SchoolDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(SchoolDTO bean) {
		log.info("SchoolDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("SchoolDAOImpl  update method end");
	}

	@Override
	public void delete(SchoolDTO bean) {
		log.info("SchoolDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("SchoolDAOImpl  delete method end");
	}

	@Override
	public SchoolDTO findByName(String name) {
		log.info("SchoolDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SchoolDTO.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("SchoolDAOImpl  login method end");
		return (SchoolDTO) criteria.uniqueResult();
	}
	
	
	@Override
	public SchoolDTO findByCode(String code) {
		log.info("SchoolDAOImpl  code method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SchoolDTO.class);
		criteria.add(Restrictions.eq("code", code));
		log.info("SchoolDAOImpl  code method end");
		return (SchoolDTO) criteria.uniqueResult();
	}

	@Override
	public SchoolDTO findByPk(long id) {
		log.info("SchoolDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("SchoolDAOImpl  findPK method end");
		return session.get(SchoolDTO.class, id);
	}

	@Override
	public List<SchoolDTO> search(SchoolDTO bean, long pageNo, int pageSize) {
		log.info("SchoolDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SchoolDTO.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("name", bean.getName() + "%"));
			}
			
			if (bean.getDistance() != null && bean.getDistance().length() > 0) {
				criteria.add(Restrictions.like("distance", bean.getDistance() + "%"));
			}
			
			if (bean.getFree() != null && bean.getFree().length() > 0) {
				criteria.add(Restrictions.like("free", bean.getFree() + "%"));
			}
			if (bean.getAffiliation() != null && bean.getAffiliation().length() > 0) {
				criteria.add(Restrictions.like("affiliation", bean.getAffiliation() + "%"));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("SchoolDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<SchoolDTO> search(SchoolDTO bean) {
		log.info("SchoolDAOImpl  search method start");

		log.info("SchoolDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public Blob getImageById(long id) throws SerialException, SQLException {
		
		Session session=sessionFactory.getCurrentSession();
		SchoolDTO person = (SchoolDTO) session.get(SchoolDTO.class, id);
        byte[] blob = person.getImage();
        Blob bBlob= new SerialBlob(blob);
		return bBlob;
	}

	@Override
	public Blob getLogoById(long id) throws SerialException, SQLException {
		Session session=sessionFactory.getCurrentSession();
		SchoolDTO person = (SchoolDTO) session.get(SchoolDTO.class, id);
        byte[] blob = person.getLogo();
        Blob bBlob= new SerialBlob(blob);
		return bBlob;
	}

}
