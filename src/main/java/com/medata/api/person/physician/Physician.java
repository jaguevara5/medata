package com.medata.api.person.physician;

import com.medata.api.person.Person;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PH")
public class Physician extends Person {

	@Column(name="Specialty")
	private String specialty = "";

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
}
