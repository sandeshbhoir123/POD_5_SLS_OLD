package in.co.school.directory.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.school.directory.dto.SuggestionDTO;

@Repository
public class SuggestionDAOImpl implements SuggestionDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());
	
	@Override
	public long add(SuggestionDTO bean) {
		log.info("SuggestionDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("SuggestionDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(SuggestionDTO bean) {
		log.info("SuggestionDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("SuggestionDAOImpl  update method end");
	}

	@Override
	public void delete(SuggestionDTO bean) {
		log.info("SuggestionDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("SuggestionDAOImpl  delete method end");
	}

	@Override
	public SuggestionDTO findByName(String name) {
		log.info("SuggestionDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SuggestionDTO.class);
		criteria.add(Restrictions.eq("name", name));
		log.info("SuggestionDAOImpl  login method end");
		return (SuggestionDTO) criteria.uniqueResult();
	}
	
	
	@Override
	public SuggestionDTO findByCode(String code) {
		log.info("SuggestionDAOImpl  code method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SuggestionDTO.class);
		criteria.add(Restrictions.eq("code", code));
		log.info("SuggestionDAOImpl  code method end");
		return (SuggestionDTO) criteria.uniqueResult();
	}

	@Override
	public SuggestionDTO findByPk(long id) {
		log.info("SuggestionDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("SuggestionDAOImpl  findPK method end");
		return session.get(SuggestionDTO.class, id);
	}

	@Override
	public List<SuggestionDTO> search(SuggestionDTO bean, long pageNo, int pageSize) {
		log.info("SuggestionDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SuggestionDTO.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("name", bean.getName() + "%"));
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("SuggestionDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<SuggestionDTO> search(SuggestionDTO bean) {
		log.info("SuggestionDAOImpl  search method start");

		log.info("SuggestionDAOImpl search method end");
		return search(bean, 0, 0);
	}

	

}
