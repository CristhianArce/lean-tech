package io.leantech.payroll.controller;

import io.leantech.payroll.dto.EmployeeDTO;
import io.leantech.payroll.exception.PositionNotFoundException;
import io.leantech.payroll.model.Employee;
import io.leantech.payroll.service.contract.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) throws PositionNotFoundException {
        employeeService.createEmployee(employeeDTO);
    }

    @PatchMapping
    public void patchEmployee(@RequestBody EmployeeDTO employeeDTO) throws PositionNotFoundException {
        employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable("id") String id){
        employeeService.deleteEmployee(Long.valueOf(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees(@RequestParam(name = "legalName", required = false) String name,
                                          @RequestParam(name = "position", required = false) String position){
        return employeeService.getAllEmployees(name, position);
    }

}
