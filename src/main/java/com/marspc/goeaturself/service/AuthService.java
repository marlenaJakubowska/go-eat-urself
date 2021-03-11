package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.User;
import com.marspc.goeaturself.exception.domain.EmailExistsException;
import com.marspc.goeaturself.exception.domain.UserNotFoundException;
import com.marspc.goeaturself.exception.domain.UsernameExistsException;

public interface AuthService {

    User register(String firstName, String username, String email, String password) throws UsernameExistsException, UserNotFoundException, EmailExistsException;

}
