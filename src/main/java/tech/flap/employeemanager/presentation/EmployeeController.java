package tech.flap.employeemanager.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.flap.employeemanager.application.dto.GetEmployeeDTO;
import tech.flap.employeemanager.application.dto.GetEmployeesDTO;
import tech.flap.employeemanager.presentation.request.CreateEmployeeRequest;
import tech.flap.employeemanager.presentation.request.UpdateEmployeeRequest;
import tech.flap.employeemanager.domain.model.Employee;
import tech.flap.employeemanager.application.service.impl.EmployeeService;
import tech.flap.employeemanager.presentation.response.GetEmployeeResponse;
import tech.flap.employeemanager.presentation.response.GetEmployeesResponse;

@RestController
@RequestMapping("/users")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping()
    public ResponseEntity<GetEmployeesResponse> getAllEmployees() {
        GetEmployeesDTO getEmployeesDTO =  employeeService.findAllEmployees();
        return new ResponseEntity<>(GetEmployeesResponse.fromDto(getEmployeesDTO), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployeeById(@PathVariable("id") Long id) {
        GetEmployeeDTO employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee.toResponse(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CreateEmployeeRequest> addEmployee(@RequestBody CreateEmployeeRequest employee) {
         employeeService.createEmployee(employee.toDTO());
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody UpdateEmployeeRequest employee) {
        employeeService.updateEmployee(employeeId, employee.toDto());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
