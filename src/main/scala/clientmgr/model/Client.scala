package clientmgr.model

import javax.persistence.Entity
import javax.annotation.Resource
import clientmgr.dao.ClientDao
import scala.collection.JavaConversions._
import java.util.{List => JList}
import javax.persistence.OneToMany
import scala.collection.mutable.ArrayBuffer

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class Client extends GeneratedId {
	
	var firstName: String = _
	
	var lastName: String = _
	
	@OneToMany 
	private var accounts: JList[Account] = _
	
	def accountList = { 
		if (accounts != null) 
		accounts.toBuffer 
		else new ArrayBuffer[Account]()
	}
}

object Client {
	
	def apply(firstName: String, lastName: String) = {
		val client = new Client
		client.firstName = firstName
		client.lastName = lastName
		
		client
	}
	
}