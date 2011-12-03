package clientmgr.rest

import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import clientmgr.model._

@Path("/client")
class ClientResource {

	@GET
	@Path("/test")
	@Produces(Array(MediaType.APPLICATION_JSON))
	def getClients = {
		val client = new ClientJ
		client.setLastName("user")
		client.setFirstName("test")
		client
	}
}