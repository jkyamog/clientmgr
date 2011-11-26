package clientmgr.dao

import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import clientmgr.model.Client
import scala.collection.JavaConversions._
import java.util.{List => JList}


class ClientDao {
	
	@PersistenceContext
	private var em: EntityManager = _

	def create(client: Client) {
		em.persist(client)
	}
	
	def update(client: Client) {
		em.merge(client)
	}
	
	def findByAll = {
		em.createQuery("select c from Client c")
			.getResultList.asInstanceOf[JList[Client]].toList
	}

}