package clientmgr.rest

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import clientmgr.model._
import clientmgr.dto.ClientDto
import java.util.ArrayList

@Path("/client")
class ClientResource {

	@GET
	@Path("/testscala")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def getClients = {
		Array(ClientDto("user", "scala1"), ClientDto("user", "scala2"))
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
