package com.warumono.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.warumono.costants.Role;
import com.warumono.domains.AuthenticatedUser;

public class AuthenticatedUserDetails extends AuthenticatedUser implements UserDetails
{
	private static final long serialVersionUID = 1L;

	public AuthenticatedUserDetails(AuthenticatedUser user)
	{
		super(user);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<GrantedAuthority> authrities = new ArrayList<GrantedAuthority>();

		String role = getRole().name();
		
		if(StringUtils.equals(Role.ROLE_STAFF.name(), role))
		{
			authrities = AuthorityUtils.createAuthorityList(role);
		}
		else if(StringUtils.equals(Role.ROLE_ADMIN.name(), role))
		{
			authrities = AuthorityUtils.createAuthorityList(Role.ROLE_STAFF.name(), role);
		}
		
		return authrities;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}
}
