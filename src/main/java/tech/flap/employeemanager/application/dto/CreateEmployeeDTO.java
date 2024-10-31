package tech.flap.employeemanager.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.flap.employeemanager.domain.model.CreatedEvent;
import tech.flap.employeemanager.domain.model.Employee;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDTO {
    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setJobTitle(jobTitle);
        employee.setPhone(phone);
        employee.setImageUrl(imageUrl);
        return employee;
    }

    public CreatedEvent createEvent() {
        return new CreatedEvent(
                email,
                name,
                surname
        );
    }
}
