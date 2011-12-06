package clientmgr.model

import javax.persistence.Entity


@Entity
class Account extends GeneratedId {

	var accountId: String = ""

}


object Account {

	def apply(accountId: String) = {
		val account = new Account
		account.accountId = accountId
		account
	}
	
}