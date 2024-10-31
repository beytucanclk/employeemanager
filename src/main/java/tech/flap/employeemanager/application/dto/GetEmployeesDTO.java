package tech.flap.employeemanager.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.flap.employeemanager.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesDTO {
    List<GetEmployeeDTO> employees;

    public static GetEmployeesDTO fromEntity(List<Employee> employees) {
        List<GetEmployeeDTO> employeeDTOList = new ArrayList<>();
        employees.forEach(employee ->  {
            employeeDTOList.add(GetEmployeeDTO.fromEntity(employee));
        });
        return new GetEmployeesDTO(employeeDTOList);
    }

}
