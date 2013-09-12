package pro.anuj.hexagon.domain;

import static javax.persistence.CascadeType.PERSIST;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>
 * Account entity class
 * </p>
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = true, unique = false)
	private String firstName;

	@NotEmpty
	@Size(min = 1, max = 100)
	@Column(nullable = true, unique = false)
	private String lastName;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(nullable = false, unique = false)
	private String password;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, unique = true)
	private String email;

	@NotNull
	@Column(nullable = true, unique = false)
	private Boolean isEnabled;

	@JoinTable(name = "ACCOUNT_ROLE", joinColumns = @JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@ManyToMany(cascade = PERSIST)
	private List<Role> roles = new ArrayList<Role>();

	@JoinTable(name = "ACCOUNT_TEAM", joinColumns = @JoinColumn(name = "ACCOUNT_ID"), inverseJoinColumns = @JoinColumn(name = "team_id"))
	@ManyToMany(cascade = PERSIST)
	private List<Team> teams = new ArrayList<Team>();

	/** GETTERS/SETTERS **/

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<Role> getRoles() {
		return (roles == null) ? roles = new ArrayList<Role>() : roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// @Transient
	// public List<String> getRoleNames() {
	// List<String> roleNames = new ArrayList<String>();
	//
	// for (Role role : getRoles()) {
	// roleNames.add(role.getRoleName());
	// }
	// return roleNames;
	// }

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
