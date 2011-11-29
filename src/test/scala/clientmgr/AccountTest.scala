package clientmgr

import org.junit.Before
import clientmgr.model.Account
import org.junit.Test
import org.junit.Assert._
import scala.collection.JavaConversions._
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import javax.annotation.Resource
import clientmgr.dao.AccountDaoJ
import clientmgr.model.AccountJ
import clientmgr.dao.AccountDao

@ContextConfiguration(locations=Array("classpath:applicationContext.xml"))
class AccountTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@PersistenceContext
	implicit private var em: EntityManager = _
	
	@Resource
	private var accountDaoJ: AccountDaoJ = _
	
	@Resource
	private var accountDao: AccountDao = _

	@Before
	def before {
		val a = Account("123")
		accountDao.create(a)
	}
	
	@Test
	def createAccountsJ {
		
		val a = new AccountJ
		a.setAccountId("123")
		
		accountDaoJ.create(a)
		
		val a2 = new AccountJ
		a2.setAccountId("456")
		
		accountDaoJ.create(a2)
		
		assertEquals(2, em.createQuery("select a from AccountJ a").getResultList.size)
		
		for (a <- accountDaoJ.findAll: Seq[AccountJ]) {
			println(a.getId + " " + a.getAccountId)
		}
	}
	
	@Test
	def createAccounts {
		val account = Account("456")
		accountDao.create(account)
		
		assertEquals(2, em.createQuery("select a from Account a").getResultList.size)
		assertEquals(2, accountDao.findAllAsList.size)
	}
	
	@Test
	def deleteAccount {
		val accounts = accountDao.findAllAsList
		
		accountDao.delete(accounts head)
		
		em.flush; em.clear;
		
		assertEquals(0, accountDao.findAllAsList.size)
	}

}