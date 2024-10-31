package tech.flap.employeemanager.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.flap.employeemanager.domain.model.Employee;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Long> {

    @Transactional
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
