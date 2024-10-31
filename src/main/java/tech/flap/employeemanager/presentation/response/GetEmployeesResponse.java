package tech.flap.employeemanager.presentation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tech.flap.employeemanager.application.dto.GetEmployeeDTO;
import tech.flap.employeemanager.application.dto.GetEmployeesDTO;
import tech.flap.employeemanager.domain.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetEmployeesResponse {
    private List<GetEmployeeResponse> employees;

    public static GetEmployeesResponse fromDto(GetEmployeesDTO dto) {
        List<GetEmployeeResponse> getEmployeeResponses = new ArrayList<>();
        dto.getEmployees().forEach(employee ->  {
            getEmployeeResponses.add(employee.toResponse());
        });
        return new GetEmployeesResponse(getEmployeeResponses);
    }
}


