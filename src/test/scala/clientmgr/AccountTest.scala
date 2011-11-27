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

@ContextConfiguration(locations=Array("classpath:applicationContext.xml"))
class AccountTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@PersistenceContext
	implicit private var em: EntityManager = _
	
	@Resource
	private var accountDaoJ: AccountDaoJ = _

	@Before
	def before {
		val a = Account.create("123")
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
		val account = Account.create("456")
		
		assertEquals(2, em.createQuery("select a from Account a").getResultList.size)
		assertEquals(2, Account.findAll.size)
	}

}