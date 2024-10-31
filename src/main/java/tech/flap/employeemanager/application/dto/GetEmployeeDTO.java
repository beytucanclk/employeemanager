package tech.flap.employeemanager.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.flap.employeemanager.domain.model.Employee;
import tech.flap.employeemanager.presentation.response.GetEmployeeResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public GetEmployeeResponse toResponse() {
        return new GetEmployeeResponse(id,name, surname, email, jobTitle, phone, imageUrl);
    }
    public static GetEmployeeDTO fromEntity(Employee employee) {
        return new GetEmployeeDTO(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getEmail(),
                employee.getJobTitle(),
                employee.getPhone(),
                employee.getImageUrl()
        );
    }
}
