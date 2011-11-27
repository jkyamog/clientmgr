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
	
	def create(account: Account)(implicit em: EntityManager) = em.persist(account)
	
	def create(accountId: String)(implicit em: EntityManager): Account = {
		val account = apply(accountId)
		create(account)
		account
	}

	def update(account: Account)(implicit em: EntityManager) = em.merge(account)
	
	def findAll(implicit em: EntityManager) = em.createQuery("select a from Account a",
			classOf[Account]).getResultList.toList
		
	def findById(id: Long)(implicit em: EntityManager) = {
		val account = em.find(classOf[Account], id)
		if (account != null) Some(account)
			else None
	}
}