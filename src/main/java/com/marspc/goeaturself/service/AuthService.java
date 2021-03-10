package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.User;

public interface AuthService {

    User register(String firstName, String username, String email, String password);

}
