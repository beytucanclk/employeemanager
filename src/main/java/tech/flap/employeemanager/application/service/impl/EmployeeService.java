package tech.flap.employeemanager.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.flap.employeemanager.application.dto.CreateEmployeeDTO;
import tech.flap.employeemanager.application.dto.GetEmployeeDTO;
import tech.flap.employeemanager.application.dto.GetEmployeesDTO;
import tech.flap.employeemanager.application.dto.UpdateEmployeeDTO;
import tech.flap.employeemanager.application.exception.UserNotFoundException;
import tech.flap.employeemanager.application.rabbitmq.MessagePublisher;
import tech.flap.employeemanager.domain.model.Employee;
import tech.flap.employeemanager.infrastructure.repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final MessagePublisher publisher;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, MessagePublisher publisher) {
        this.employeeRepo = employeeRepo;
        this.publisher = publisher;
    }

    public void createEmployee(CreateEmployeeDTO employee) {
        employeeRepo.save(employee.toEntity());
        publisher.produceMessage(employee.createEvent());
    }

    public GetEmployeesDTO findAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();


        return GetEmployeesDTO.fromEntity(employees);
    }

    public void updateEmployee(Long employeeId, UpdateEmployeeDTO dto) {
        try{
            Employee employee = employeeRepo.getById(employeeId);
            employee.updateEmployee(dto);
            employeeRepo.save(employee);
        }catch (Exception e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }

    public GetEmployeeDTO findEmployeeById(Long id) {
        Employee employee =  employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
        return GetEmployeeDTO.fromEntity(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
