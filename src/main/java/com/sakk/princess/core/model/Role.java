package com.sakk.princess.core.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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
@Table(name = "ROLES")
public class Role extends BaseEntity implements Serializable, GrantedAuthority  {

    private static final long serialVersionUID = 6874667425302308430L;
    static Logger logger = LoggerFactory.getLogger(Role.class);
    /*
        CREATE TABLE `ROLES` (
            `ID` INT(6) NOT NULL,
            `ROLENAME`  VARCHAR(50) NOT NULL,
            PRIMARY KEY (`ID`)
        )
        ENGINE=InnoDB DEFAULT CHARSET=utf8; 
     */

    @NotNull(message = "{error.roles.role.null}")
    @NotEmpty(message = "{error.roles.role.empty}")
    @Size(max = 50, message = "{error.roles.role.max}")
    @Column(name = "rolename", length = 50)
    private String roleName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(name = "user_roles",   
        joinColumns        = {@JoinColumn(name = "role_id", referencedColumnName = "id")},  
        inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}  
    )  
    private List<User> userList;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JoinTable(name = "role_permissions",
        joinColumns        = { @JoinColumn(name = "role_id",       referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "permission_id", referencedColumnName = "id") }
    )    
    private List<Permission> permissionList;

    public String getRolename() {
        return roleName;
    }

    public void setRolename(String rolename) {
        this.roleName = rolename;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() { 
        return permissionList; 
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }
    
    @Override
    public String toString() {
        return String.format("%s(id=%d, rolename='%s')", 
                this.getClass().getSimpleName(), 
                this.getId(), this.getRolename());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (o instanceof Role) {
            final Role other = (Role) o;
            return Objects.equal(getId(), other.getId())
                    && Objects.equal(getRolename(), other.getRolename());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getRolename());
    }

    @Override
    public String getAuthority() {
        return getRolename();
    }
}