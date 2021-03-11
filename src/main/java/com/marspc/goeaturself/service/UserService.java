package com.marspc.goeaturself.service;

import com.marspc.goeaturself.domain.User;

public interface UserService {
    User findUserByUsername(String username);
}
