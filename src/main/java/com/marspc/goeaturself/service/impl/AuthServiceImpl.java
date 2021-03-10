package com.marspc.goeaturself.service.impl;

import com.marspc.goeaturself.domain.User;
import com.marspc.goeaturself.repository.UserRepository;
import com.marspc.goeaturself.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.Date;

import static com.marspc.goeaturself.enums.Role.ROLE_USER;

@Service
@Transactional
@Qualifier("userDetailsService")
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LoginAttemptService loginAttemptService;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, LoginAttemptService loginAttemptService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginAttemptService = loginAttemptService;
    }

    @Override
    public User register(String firstName, String username, String email, String password) {
        validateNewUsernameAndEmail(StringUtils.EMPTY, username, email);
        User user = new User();
        user.setFirstName(firstName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encodePassword(password));
        user.setJoinDate(new Date());
        user.setIsActive(true);
        user.setIsNonLocked(true);
        user.setRole(ROLE_USER.name());
        user.setAuthorities(ROLE_USER.getAuthorities());
        userRepository.save(user);
        return user;
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private void validateNewUsernameAndEmail(String empty, String username, String email) {
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
