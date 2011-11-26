package clientmgr

import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.junit.Test
import org.junit.Assert._
import javax.annotation.Resource
import clientmgr.dao.ClientDao
import clientmgr.model.Client
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager

@ContextConfiguration(locations=Array("classpath:applicationContext.xml"))
class ClientTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Resource
	implicit var clientDao: ClientDao = _
	
	@PersistenceContext
	private var em: EntityManager = _
	
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

}