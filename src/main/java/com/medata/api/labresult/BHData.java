package com.medata.api.labresult;

import javax.persistence.*;

@Entity
@Table(name = "BHData")
public class BHData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BHDataId")
	private int id;

	@Column(name="Eritrocitos")
	private double eritrocitos;

	@Column(name="Hemoglobina")
	private double hemoglobina;

	@Column(name="Hematocrito")
	private double hematocrito;

	@Column(name="VGM")
	private double vgm;

	@Column(name="CMHC")
	private double cmhc;

	@Column(name="HCM")
	private double hcm;

	@Column(name="RDW")
	private double rdw;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEritrocitos() {
		return eritrocitos;
	}

	public void setEritrocitos(double eritrocitos) {
		this.eritrocitos = eritrocitos;
	}

	public double getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(double hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public double getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(double hematocrito) {
		this.hematocrito = hematocrito;
	}

	public double getVgm() {
		return vgm;
	}

	public void setVgm(double vgm) {
		this.vgm = vgm;
	}

	public double getCmhc() {
		return cmhc;
	}

	public void setCmhc(double cmhc) {
		this.cmhc = cmhc;
	}

	public double getHcm() {
		return hcm;
	}

	public void setHcm(double hcm) {
		this.hcm = hcm;
	}

	public double getRdw() {
		return rdw;
	}

	public void setRdw(double rdw) {
		this.rdw = rdw;
	}
}
