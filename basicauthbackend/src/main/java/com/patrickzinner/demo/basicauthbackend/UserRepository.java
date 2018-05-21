package com.patrickzinner.demo.basicauthbackend;

import com.patrickzinner.demo.basicauthbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public User findByUsernameOrEmailAddress(String username, String emailAddress);

}
