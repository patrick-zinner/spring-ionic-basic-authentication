package com.patrickzinner.demo.basicauthbackend.service;

import com.patrickzinner.demo.basicauthbackend.UserRepository;
import com.patrickzinner.demo.basicauthbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Implementation of {@link UserDetailsService}. This service is used in the {@link com.patrickzinner.demo.basicauthbackend.BasicAuthConfiguration} for the {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider}.
 *
 * @see UserDetailsService's documentation for further information.
 */
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("There was no user named " + username);
        }
        return user;
    }

    public User createUser(String username, String emailAddress, String password) {

        //username and emailaddress must be unique
        if (userRepository.findByUsernameOrEmailAddress(username, emailAddress) != null) {
            throw new IllegalArgumentException("User " + username + " or email " + emailAddress + " already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmailAddress(emailAddress);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
