package clientmgr.dao

import clientmgr.model.Client


class ClientDao extends SimpleCRUD[Client] {
	override def getClazz = classOf[Client]
}
