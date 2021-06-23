package io.leantech.payroll.service.implementation;

import io.leantech.payroll.dto.EmployeeDTO;
import io.leantech.payroll.exception.EmployeeNotFoundException;
import io.leantech.payroll.exception.PositionNotFoundException;
import io.leantech.payroll.model.Candidate;
import io.leantech.payroll.model.Employee;
import io.leantech.payroll.model.Position;
import io.leantech.payroll.repository.CandidateRepository;
import io.leantech.payroll.repository.EmployeeRepository;
import io.leantech.payroll.repository.PositionRepository;
import io.leantech.payroll.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    PositionRepository positionRepository;

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) throws PositionNotFoundException {

        Position position = positionRepository.findPositionByName(employeeDTO.getPosition().getName())
                .orElseThrow(() ->  new PositionNotFoundException(
                        String.format("The position [%s] does not exist",employeeDTO.getPosition().getName())));

        Optional<Candidate> OptionalCandidate = candidateRepository.findById(employeeDTO.getCandidate().getIdCandidate());

        Candidate savedCandidate = !OptionalCandidate.isPresent() ? candidateRepository.save(employeeDTO.getCandidate()) : OptionalCandidate.get();
        Employee employee = new Employee();
        employee.setCandidate(savedCandidate);
        employee.setPosition(position);
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.getEmployeeByCandidateId(String.valueOf(employeeDTO.getCandidate().getIdCandidate()))
                .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with candidateId [%s]", employeeDTO.getCandidate().getIdCandidate())));

        employee.setCandidate(employeeDTO.getCandidate());
        employee.setSalary(employeeDTO.getSalary());
        employee.setPosition(employeeDTO.getPosition());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployees(String name, String position) {
        boolean nameParameterCriteria = name != null;
        boolean positionParameterCriteria = position != null;

        if(nameParameterCriteria) { return employeeRepository.getEmployeesWithSameName(name); }
        if(positionParameterCriteria) { return  employeeRepository.getEmployeesWithSamePosition(position); }

        return employeeRepository.getAllEmployees();
    }
}
