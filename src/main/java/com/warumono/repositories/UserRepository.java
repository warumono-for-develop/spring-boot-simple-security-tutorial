package com.warumono.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warumono.domains.AuthenticatedUser;

@Repository
public interface UserRepository extends JpaRepository<AuthenticatedUser, Long>
{
	Optional<AuthenticatedUser> findOneByUsername(String username);
}
