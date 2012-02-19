package clientmgr.dao

import clientmgr.model.Account
import org.springframework.stereotype.Component

@Component
class AccountDao extends SimpleCRUD[Account] {
	override def getClazz = classOf[Account]
}