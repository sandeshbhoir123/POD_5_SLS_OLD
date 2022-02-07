package in.co.school.directory.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.school.directory.dto.UserDTO;


@Repository
public class UserDAOimpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(getClass().getName());

	@Override
	public long add(UserDTO bean) {
		log.info("UserDAOImpl  add method start");
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(bean);
		log.info("UserDAOImpl  add method end");
		return pk;
	}

	@Override
	public void update(UserDTO bean) {
		log.info("UserDAOImpl  update method start");
		sessionFactory.getCurrentSession().merge(bean);
		log.info("UserDAOImpl  update method end");
	}

	@Override
	public void delete(UserDTO bean) {
		log.info("UserDAOImpl  delete method start");
		sessionFactory.getCurrentSession().delete(bean);
		log.info("UserDAOImpl  delete method end");
	}

	@Override
	public UserDTO findByLogin(String login) {
		log.info("UserDAOImpl  login method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("loginId", login));
		log.info("UserDAOImpl  login method end");
		return (UserDTO) criteria.uniqueResult();
	}

	@Override
	public UserDTO findByPk(long id) {
		log.info("UserDAOImpl  findPk method start");
		Session session = sessionFactory.getCurrentSession();
		log.info("UserDAOImpl  findPK method end");
		return session.get(UserDTO.class, id);
	}

	@Override
	public List<UserDTO> search(UserDTO bean, long pageNo, int pageSize) {
		log.info("UserDAOImpl  search method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		if (bean != null) {

			if (bean.getId() > 0) {
				criteria.add(Restrictions.eq("id", bean.getId()));
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				criteria.add(Restrictions.like("Name", bean.getName() + "%"));
			}
			if (bean.getEmailId() != null && bean.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", bean.getEmailId() + "%"));
			}
			if (bean.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", bean.getRoleId()));
			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("UserDAOImpl  search method end");
		return criteria.list();
	}

	@Override
	public List<UserDTO> search(UserDTO bean) {
		log.info("UserDAOImpl  search method start");

		log.info("UserDAOImpl search method end");
		return search(bean, 0, 0);
	}

	@Override
	public UserDTO authenticate(UserDTO bean) {
		log.info("UserDAOImpl  Authenticate method start");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("loginId", bean.getLoginId()));
		criteria.add(Restrictions.like("password", bean.getPassword()));
		log.info("UserDAOImpl  Authenticate method end");
		return (UserDTO)criteria.uniqueResult();
	}

}
