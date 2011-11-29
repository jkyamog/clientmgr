package clientmgr.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.EntityManager
import scala.collection.JavaConversions._
import java.util.{List => JList}
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import scala.reflect.BeanProperty

@Entity
class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Int = _
	
	var accountId: String = _

}


object Account {

	def apply(accountId: String) = {
		val account = new Account
		account.accountId = accountId
		account
	}
	
}