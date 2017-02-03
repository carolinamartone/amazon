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
@Table(name = "USER_ROLES")
public class UserRoles {
	@Id
	@Column(name = "USER_ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userRoleId;

	@Column(name = "ROLE", nullable = false)
	public String role;

	@OneToOne(optional = false, mappedBy = "userRoles", fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "USERNAME", nullable = false, insertable = true, unique = true)
	private User user;

	public UserRoles(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
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
