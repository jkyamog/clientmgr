package clientmgr.rest
import javax.ws.rs.Path
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/client")
class ClientResource {

	@GET
	@Produces(Array(MediaType.APPLICATION_JSON))
	def getClients = {
		"hello"
	}
}