package it.csttech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private boolean active;

	@OneToOne(optional = false, targetEntity = UserRoles.class)
	@JoinColumn(name = "userRoleId", nullable = false, insertable = false, updatable = false)
	private UserRoles userRoles;

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User(String username, String password, boolean active, UserRoles userRoles) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", active=" + active + ", userRoles="
				+ userRoles + "]";
	}

	public User() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
