package clientmgr.dao

import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import clientmgr.model.Client
import scala.collection.JavaConversions._
import java.util.{List => JList}


class ClientDao extends SimpleCRUD[Client] {
	override def getClazz = classOf[Client]
}
