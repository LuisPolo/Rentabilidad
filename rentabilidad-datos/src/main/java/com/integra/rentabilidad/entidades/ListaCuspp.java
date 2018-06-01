package com.integra.rentabilidad.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListaCuspp implements Serializable {

	private static final long serialVersionUID = 1L;

	public ListaCuspp() {
		super();
	}
   
	@Id
	@Column(name = "CUSPP")
	private String cuspp;
	@Column(name = "FLAG")
	private String flag;

	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
