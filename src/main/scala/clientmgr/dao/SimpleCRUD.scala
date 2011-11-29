package clientmgr.dao

import javax.persistence.PersistenceContext
import javax.persistence.EntityManager
import scala.collection.JavaConversions._
import java.util.{List => JList}

trait SimpleCRUD[T] {
	
	@PersistenceContext
	private var em: EntityManager = _

	def create(model: T) = em.persist(model)
	
	def update(model: T) = em.merge(model)
	
	def delete(model: T) = em.remove(model)

	def findById(id: Long) = {
		val model = em.find(getClazz, id)
		if (model != null) Some(model)
			else None
	}
	
	def findAllAsList = em.createQuery("from " + getClazz.getCanonicalName)
		.getResultList.asInstanceOf[JList[T]].toList
	
	// for now need to do this, as jpa requires runtime type info and can't work w/ generics/type system of scala
	// which is also done via type erasure like java
	def getClazz: Class[T]	

}