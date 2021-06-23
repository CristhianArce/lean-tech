package io.leantech.payroll.service.contract;

import io.leantech.payroll.dto.EmployeeDTO;
import io.leantech.payroll.exception.EmployeeNotFoundException;
import io.leantech.payroll.exception.PositionNotFoundException;
import io.leantech.payroll.model.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(EmployeeDTO employeeDTO) throws PositionNotFoundException;
    void updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException;
    void deleteEmployee(Long id);
    List<Employee> getAllEmployees(String name, String position);

}
