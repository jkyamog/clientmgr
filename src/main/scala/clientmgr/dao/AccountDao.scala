package clientmgr.dao

import clientmgr.model.Account

class AccountDao extends SimpleCRUD[Account] {
	override def getClazz = classOf[Account]
}