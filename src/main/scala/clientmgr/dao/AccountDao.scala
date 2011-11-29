package clientmgr.dao

import clientmgr.model.Account
import scala.collection.JavaConversions._
import javax.persistence.PersistenceContext
import javax.persistence.EntityManager

class AccountDao extends SimpleCRUD[Account] {
	override def getClazz = classOf[Account]
}