package tech.flap.employeemanager.presentation.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.flap.employeemanager.application.dto.UpdateEmployeeDTO;

@Getter
@NoArgsConstructor
public class UpdateEmployeeRequest {
    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public UpdateEmployeeDTO toDto() {
        return new UpdateEmployeeDTO(name, surname, email, jobTitle, phone, imageUrl);
    }
}
