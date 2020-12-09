package com.medata.api.labresult;

import com.medata.api.lab.Lab;
import com.medata.api.person.patient.Patient;
import com.medata.api.person.physician.Physician;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "resultType")
@DiscriminatorColumn(name = "testResultType", discriminatorType = DiscriminatorType.STRING)
@JsonSubTypes({
	@JsonSubTypes.Type(value=BHResult.class, name="bh"),
})
@Table(name="LabResults")
public class LabResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LabResultId")
	private int id;

	@Column(name="DateAdministered")
	private Date dateAdministered = null;

	@Column(name="ResultsDate")
	@Temporal(TemporalType.DATE)
	private Date resultsDate = null;

	@OneToOne
	@JoinColumn(name="PatientId")
	private Patient patient = null;

	@OneToOne
	@JoinColumn(name="LabId")
	private Lab lab = null;

	@OneToOne
	@JoinColumn(name="PhysicianId")
	private Physician physician = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateAdministered() {
		return dateAdministered;
	}

	public void setDateAdministered(Date dateAdministered) {
		this.dateAdministered = dateAdministered;
	}

	public Date getResultsDate() {
		return resultsDate;
	}

	public void setResultsDate(Date resultsDate) {
		this.resultsDate = resultsDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Lab getLab() {
		return lab;
	}

	public void setLab(Lab lab) {
		this.lab = lab;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}
}
