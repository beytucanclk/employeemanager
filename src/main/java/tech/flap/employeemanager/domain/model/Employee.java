package tech.flap.employeemanager.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.flap.employeemanager.application.dto.UpdateEmployeeDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public void updateEmployee(UpdateEmployeeDTO employeeDto) {
        name = employeeDto.getName();
        surname = employeeDto.getSurname();
        email = employeeDto.getEmail();
        jobTitle = employeeDto.getJobTitle();
        phone = employeeDto.getPhone();
        imageUrl = employeeDto.getImageUrl();
    }

}
