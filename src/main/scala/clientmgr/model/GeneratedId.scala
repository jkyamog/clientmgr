package clientmgr.model

import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

trait GeneratedId {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long = _
	
}