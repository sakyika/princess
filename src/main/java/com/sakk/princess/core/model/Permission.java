package com.sakk.princess.core.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.base.Objects;

@Entity
@Table(name = "PERMISSIONS")
public class Permission extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = -5404269148967698143L;
	static Logger logger = LoggerFactory.getLogger(Permission.class);

	@NotNull(message = "{error.permission.permissionname.null}")
	@NotEmpty(message = "{error.permission.permissionname.empty}")
	@Size(max = 50, message = "{permission.permissionname.role.max}")
	@Column(name = "permissionname", length = 50)
	private String permissionName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	//@JsonBackReference
	@JoinTable(name = "role_permissions", 
		joinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }, 
		inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private List<Role> roleList;

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	@Override
	public String getAuthority() {
		return permissionName;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return String.format("%s(id=%d, permissionname='%s')", this.getClass()
				.getSimpleName(), this.getId(), this.getPermissionName());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;

		if (o instanceof Permission) {
			final Permission other = (Permission) o;
			return Objects.equal(getId(), other.getId())
					&& Objects.equal(getPermissionName(),
							other.getPermissionName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId(), getPermissionName());
	}
}
