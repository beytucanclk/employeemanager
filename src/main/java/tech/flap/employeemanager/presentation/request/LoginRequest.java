package tech.flap.employeemanager.presentation.request;

import lombok.Getter;
import lombok.Setter;
import tech.flap.employeemanager.application.dto.LoginDto;

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;

    public LoginDto toDto(){
        return new LoginDto(username, password);
    }
}
