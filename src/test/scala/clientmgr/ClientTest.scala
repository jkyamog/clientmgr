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

@ContextConfiguration(locations=Array("classpath:applicationContext.xml"))
class ClientTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Resource
	implicit var clientDao: ClientDao = _
	
	@PersistenceContext
	implicit private var em: EntityManager = _
	
	@Test
	def createClients {
		val client = Client("John", "Smith")
		
		clientDao.create(client)
		
		val clients = clientDao.findByAll
		
		assertEquals(1, clients.size)
		
		assertEquals(1, Client.findAll.size)
		
	}
	
	@Test
	def updateClients {
		Client.create("John", "Smith")
		
		val clients = Client.findAll
		
		val updatedClients = clients map { client =>
			client.firstName = "Updated"
			client
		}
		
		updatedClients.foreach (Client.update)
		
		em.flush; em.clear
		
		val clients2 = Client.findAll
		
		assertEquals(1, clients filter (_.firstName == "Updated") size)
	}
	
	@Test
	def addAccounts {
		val client = Client.create("John", "Smith")
		val account = Account.create("123")
		
		client.accountList += account
		
		Client.update(client)
		
		em.flush; em.clear
		
		val clients = em.createQuery("select c from Client c", classOf[Client]).getResultList.toList
		
		val clientsWithAccounts = clients filter (_.accountList.size == 0)
		
		assertEquals(1, clientsWithAccounts size)
		
		val accounts = Account.findAll
		
		clientsWithAccounts foreach { client =>
			client.accountList foreach { account =>
				assertTrue(accounts exists (_.accountId == account.accountId))
			}
		}
		
	}

}