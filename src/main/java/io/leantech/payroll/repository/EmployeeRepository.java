package io.leantech.payroll.repository;

import io.leantech.payroll.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.candidate.name = :name")
    List<Employee> getEmployeesWithSameName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.position.name = :position")
    List<Employee> getEmployeesWithSamePosition(@Param("position") String position);

    @Query("SELECT e FROM Employee e")
    List<Employee> getAllEmployees();

    @Query("SELECT e FROM Employee e WHERE e.candidate.id = :id")
    Optional<Employee> getEmployeeByCandidateId(@Param("id") String id);

}
