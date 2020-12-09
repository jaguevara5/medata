package com.medata.api.lab;

import javax.persistence.*;

@Entity
@Table(name="Labs")
public class Lab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LabId")
	private int id;

	@Column(name="LabName")
	private String name = "";

	@Column(name="RFC")
	private String rfc = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}
