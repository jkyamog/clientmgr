package clientmgr.model

import javax.persistence.Entity
import java.util.{List => JList}
import java.util.ArrayList
import javax.persistence.OneToMany
import javax.persistence.CascadeType
import javax.persistence.Enumerated
import javax.persistence.EnumType

@Entity
class Client extends GeneratedId {
	
	var firstName: String = ""
	
	var lastName: String = ""
	
	@OneToMany(cascade=Array(CascadeType.ALL))
	var accounts: JList[Account] = new ArrayList
	
	@Enumerated(value = EnumType.STRING)
	var clientType: ClientType = _
}

object Client {
	
	def apply(firstName: String, lastName: String) = {
		val client = new Client
		client.firstName = firstName
		client.lastName = lastName
		client.clientType = ClientType.Public
		
		client
	}
	
}