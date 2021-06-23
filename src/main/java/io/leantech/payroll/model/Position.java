package io.leantech.payroll.model;

import org.springframework.http.MediaType;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_position")
	@SequenceGenerator(name = "someSeq", sequenceName ="SOME_SEQ", initialValue=4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "someSeq")
	private long idPosition;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="position")
	private List<Employee> employees;

	public Position() {
	}

	public long getIdPosition() {
		return this.idPosition;
	}

	public void setIdPosition(long idPosition) {
		this.idPosition = idPosition;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setPosition(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setPosition(null);

		return employee;
	}

}