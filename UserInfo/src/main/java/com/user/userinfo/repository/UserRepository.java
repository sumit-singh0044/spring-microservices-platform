package com.user.userinfo.repository;

import com.user.userinfo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Query("""
        SELECT DISTINCT u
        FROM Users u
        LEFT JOIN FETCH u.addresses
        """)
    List<Users> findAllAddress();
}
