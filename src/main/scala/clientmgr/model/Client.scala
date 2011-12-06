package clientmgr.model

import javax.persistence.Entity
import java.util.{List => JList}
import java.util.ArrayList
import javax.persistence.OneToMany
import scala.collection.JavaConversions._
import javax.persistence.JoinTable

@Entity
class Client extends GeneratedId {
	
	var firstName: String = ""
	
	var lastName: String = ""
	
	@OneToMany
	@JoinTable(name = "Client_Accounts")
	private var _accounts: JList[Account] = new ArrayList
	
	def accounts = _accounts.toBuffer
}

object Client {
	
	def apply(firstName: String, lastName: String) = {
		val client = new Client
		client.firstName = firstName
		client.lastName = lastName
		
		client
	}
	
}