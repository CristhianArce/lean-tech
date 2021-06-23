package io.leantech.payroll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_candidate")
	@SequenceGenerator(name = "someSeq", sequenceName ="SOME_SEQ", initialValue=4)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "someSeq")
	private long idCandidate;

	private String address;

	private String cellphone;

	private String city;

	private String lastname;

	private String name;

	@JsonIgnore
	@OneToOne
	private Employee employees;

	public Candidate() {
	}

	public long getIdCandidate() {
		return this.idCandidate;
	}

	public void setIdCandidate(long idCandidate) {
		this.idCandidate = idCandidate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}


}