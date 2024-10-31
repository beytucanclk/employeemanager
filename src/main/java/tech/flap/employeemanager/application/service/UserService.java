package tech.flap.employeemanager.application.service;

import tech.flap.employeemanager.application.dto.LoginDto;
import tech.flap.employeemanager.application.dto.LoginResponseDto;
import tech.flap.employeemanager.domain.model.User;

import java.util.List;

public interface UserService {

    User registerNewUser(User user);

    List<User> findAll();

    LoginResponseDto login(LoginDto loginDto);
}
