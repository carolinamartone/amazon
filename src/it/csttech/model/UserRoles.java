package it.csttech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
// @constraint
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_role_id")
	private int userRoleId;

	@Column(nullable = false)
	// TODO: relationship with user
	public String username;

	@Column(nullable = false)
	public String role;

	@OneToOne(mappedBy = "userRoles", fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "username", nullable = false, insertable = true, unique = true)
	private User user;

	public UserRoles(int userRoleId, String username, String role) {
		this.userRoleId = userRoleId;
		this.username = username;
		this.role = role;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRoles() {
	}

}
