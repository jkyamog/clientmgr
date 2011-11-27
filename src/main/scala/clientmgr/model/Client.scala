package clientmgr.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.annotation.Resource
import clientmgr.dao.ClientDao
import scala.collection.JavaConversions._
import java.util.{List => JList}
import javax.persistence.OneToMany
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import scala.collection.mutable.ArrayBuffer


@Entity
class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long = _
	
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
	
	def findAll(implicit clientDao: ClientDao) = clientDao.findByAll
	
	def create(firstName: String, lastName: String)(implicit clientDao: ClientDao): Client = {
		val client = apply(firstName, lastName)
		create(client)
		client
	}
	
	def create(client: Client)(implicit clientDao: ClientDao) {
		clientDao.create(client)
	}
	
	def update(client: Client)(implicit clientDao: ClientDao) {
		clientDao.update(client)
	}
}