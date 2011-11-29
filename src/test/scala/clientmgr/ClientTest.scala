package clientmgr

import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.junit.Test
import org.junit.Assert._
import scala.collection.JavaConversions._
import javax.annotation.Resource
import clientmgr.dao.ClientDao
import clientmgr.model.Client
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import clientmgr.model.Account
import clientmgr.dao.AccountDao

@ContextConfiguration(locations=Array("classpath:applicationContext.xml"))
class ClientTest extends AbstractTransactionalJUnit4SpringContextTests {

	@PersistenceContext
	private var em: EntityManager = _

	@Resource
	var clientDao: ClientDao = _
	
	@Resource
	var accountDao: AccountDao = _

	@Test
	def createClients {
		val client = Client("John", "Smith")
		
		clientDao.create(client)
		
		val clients = clientDao.findAllAsList
		
		assertEquals(1, clients.size)
		
		assertEquals(1, clientDao.findAllAsList.size)
		
	}
	
	@Test
	def updateClients {
		clientDao.create(Client("John", "Smith"))
		
		val clients = clientDao.findAllAsList
		
		val updatedClients = clients map { client =>
			client.firstName = "Updated"
			client
		}
		
		updatedClients.foreach (clientDao.update)
		
		em.flush; em.clear
		
		val clients2 = clientDao.findAllAsList
		
		assertEquals(1, clients filter (_.firstName == "Updated") size)
	}
	
	@Test
	def addAccounts {
		
		val client = Client("John", "Smith")
		clientDao.create(client)
		val account = Account("123")
		accountDao.create(account)
		
		client.accountList += account
		
		clientDao.update(client)
		
		em.flush; em.clear
		
		val clients = em.createQuery("select c from Client c", classOf[Client]).getResultList.toList
		
		val clientsWithAccounts = clients filter (_.accountList.size == 0)
		
		assertEquals(1, clientsWithAccounts size)
		
		val accounts = accountDao.findAllAsList
		
		clientsWithAccounts foreach { client =>
			client.accountList foreach { account =>
				assertTrue(accounts exists (_.accountId == account.accountId))
			}
		}
		
	}

}