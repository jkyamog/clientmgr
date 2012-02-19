package clientmgr.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import clientmgr.common.Util;

@Entity
public class Role {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String roleName;
	
   @ManyToMany(mappedBy="roles")
	private Collection<User> users;

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Collection<User> getUsers() {
		return users;
	}
   
   @Override
   public boolean equals(Object o) {
      if (!(o instanceof Role)) return false;
      
      Role other = (Role) o;
      return Util.areEqual(roleName, other.roleName);
   }
   @Override
   public int hashCode() {
      return (roleName == null) ? 0 : roleName.hashCode();
   }
	
}
