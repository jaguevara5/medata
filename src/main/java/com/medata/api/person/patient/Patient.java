package com.medata.api.person.patient;

import com.medata.api.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "Patients")
@DiscriminatorValue("PT")
public class Patient extends Person {
}
