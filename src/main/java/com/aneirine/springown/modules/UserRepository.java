package com.aneirine.springown.modules;

import com.aneirine.springown.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
