package tech.flap.employeemanager.presentation.request;

import lombok.*;
import tech.flap.employeemanager.domain.model.UserRole;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserData {

    private String username;
    private String email;
    private String fullName;
    private String password;
    private UserRole appUserRole;
}