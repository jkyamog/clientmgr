package clientmgr.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

   private String userName;
	private String password;
	private Boolean enabled;
	private String firstName;
	private String lastName;
	
   @ManyToMany(cascade=CascadeType.ALL)
   @JoinTable(name="user_role",
        joinColumns=@JoinColumn(name="user_id"),
          inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getEnabled() {
		return enabled;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Set<Role> getRoles() {
		return roles;
	}

}
