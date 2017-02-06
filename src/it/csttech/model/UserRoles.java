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

	@OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "ROLE_ID", nullable = false, insertable = true)
	private Role role;

	@OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "USERNAME", nullable = false, insertable = true, unique = true)
	private User user;

	public UserRoles(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRoles() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
