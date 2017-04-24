package com.warumono.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.warumono.costants.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "USERS")
public class AuthenticatedUser
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Size(max = 30)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotEmpty
	@Size(max = 255)
	private String password;

	@NotEmpty
	@Size(max = 20)
	private String name;

	@Column
	@Enumerated(value = EnumType.STRING)
	private Role role;
	
	public AuthenticatedUser(AuthenticatedUser user)
	{
		id = user.getId();
		username = user.getUsername();
		password = user.getPassword();
		name = user.getName();
		role = user.getRole();
	}
	
	public static final AuthenticatedUser staff()
	{
		return new AuthenticatedUser(null, null, null, null, Role.ROLE_STAFF);
	}
}
