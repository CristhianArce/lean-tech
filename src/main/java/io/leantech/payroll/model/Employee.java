package io.leantech.payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_employee")
	@SequenceGenerator(name = "someSeq", sequenceName ="SOME_SEQ", initialValue=4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "someSeq")
	private long idEmployee;

	private BigDecimal salary;

	//bi-directional many-to-one association to Candidate
	@OneToOne
	private Candidate candidate;

	//bi-directional many-to-one association to Position
	@JsonIgnore
	@ManyToOne
	private Position position;

	public Employee() {
	}

	public long getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Candidate getCandidate() {
		return this.candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}