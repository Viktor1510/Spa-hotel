package com.our.spahotel.service;

import com.our.spahotel.model.UserDto;
import com.our.spahotel.persistence.User;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    String registerUser(UserDto registerDto);
    String login(HttpServletRequest req, UserDto userDto);
    void logout(HttpServletRequest req);
}
