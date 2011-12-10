package clientmgr.rest

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import clientmgr.model._
import clientmgr.dto.ClientDto
import java.util.ArrayList
import javax.annotation.Resource
import clientmgr.dao.ClientDao
import com.sun.jersey.spi.inject.Inject
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

@Component
@Path("/client")
class ClientResource {
	
	@Autowired
	var clientDao: ClientDao = _

	@GET
	@Path("/testscala")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def getClients = {
		clientDao.create(Client("test", "user"))
		
		clientDao.findAllAsList map(c => ClientDto(c.firstName, c.lastName))
		
	}

	@GET
	@Path("/testjava")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def getClientsJ = {
		var client = new ClientJ
		client.setLastName("user")
		client.setFirstName("test")
		
		val jList = new ArrayList[ClientJ]
		jList.add(client)

		client = new ClientJ
		client.setLastName("user2")
		client.setFirstName("test2")
		jList.add(client)

		jList
	}

}
