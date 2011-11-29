package clientmgr.model

import javax.persistence.Entity
import java.util.{List => JList}
import javax.persistence.OneToMany
import clientmgr.util.CollectionUtils._
import javax.persistence.JoinTable

@Entity
class Client extends GeneratedId {
	
	var firstName: String = _
	
	var lastName: String = _
	
	@OneToMany
	@JoinTable(name = "Client_Accounts")
	private var _accounts: JList[Account] = _
	
	def accounts = asBufferOrEmptyBuffer[Account](_accounts) 
}

object Client {
	
	def apply(firstName: String, lastName: String) = {
		val client = new Client
		client.firstName = firstName
		client.lastName = lastName
		
		client
	}
	
}