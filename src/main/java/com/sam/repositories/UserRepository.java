package com.sam.repositories;

import com.sam.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("update User u set u.failedAttempt =?1 where u.username =?2")
    @Modifying
    User updateFailedAttempts(Integer failedAttempts, String username);

}
