package tech.flap.employeemanager.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.flap.employeemanager.application.dto.CreateEmployeeDTO;

@Getter
@NoArgsConstructor
public class CreateEmployeeRequest {
    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public CreateEmployeeDTO toDTO() {
        return new CreateEmployeeDTO(name, surname, email, jobTitle, phone, imageUrl);
    }
}
