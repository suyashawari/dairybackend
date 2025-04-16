package com.onlinedairy.repository;
import com.onlinedairy.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmailAndPassword(String email, String password);

    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByName(String name);

}