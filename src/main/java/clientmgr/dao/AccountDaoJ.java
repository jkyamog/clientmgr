package clientmgr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import clientmgr.model.AccountJ;

public class AccountDaoJ {

	@PersistenceContext
	private EntityManager em;
	
	public void create(AccountJ account) {
		em.persist(account);
	}
	
	public void update(AccountJ account) {
		em.merge(account);
	}
	
	public List<AccountJ> findAll() {
		return em.createQuery("select a from AccountJ a", AccountJ.class).getResultList();
	}

}
