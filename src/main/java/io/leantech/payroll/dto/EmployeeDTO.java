package io.leantech.payroll.dto;
import io.leantech.payroll.model.Candidate;
import io.leantech.payroll.model.Position;
import java.math.BigDecimal;

public class EmployeeDTO {


    private BigDecimal salary;
    private Candidate candidate;
    private Position position;

    public EmployeeDTO() {
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
