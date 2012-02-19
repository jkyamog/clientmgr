package clientmgr.dao

import clientmgr.model.Client
import org.springframework.stereotype.Component

@Component
class ClientDao extends SimpleCRUD[Client] {
	override def getClazz = classOf[Client]
}
