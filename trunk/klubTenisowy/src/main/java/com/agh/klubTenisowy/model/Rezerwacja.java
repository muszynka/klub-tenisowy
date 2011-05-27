package com.agh.klubTenisowy.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Rezerwacja")
public class Rezerwacja {
	@Id
	@GeneratedValue
	private Integer id;
	private Date poczatek;
	private Date koniec;
	private Date dzien;
	private String kort;
	private Boolean dostepna;
	private Boolean wykorzystana;
	private Boolean zawody;
	@ManyToOne
	private Klient klient;

	public Rezerwacja() {
	}

	public Rezerwacja(Date poczatek, Date koniec, Date dzien, String kort) {
		super();
		this.poczatek = poczatek;
		this.koniec = koniec;
		this.dzien = dzien;
		this.kort = kort;
		this.klient = null;
		this.dostepna = true;
		this.wykorzystana = false;
		this.zawody = false;
	}

	public String dajZakresString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("HH:mm");
		return sdf.format(poczatek) + "-" +sdf.format(koniec);
	}
	
	public String dajDzienString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-DD");
		return sdf.format(poczatek);
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPoczatek() {
		return poczatek;
	}

	public void setPoczatek(Date poczatek) {
		this.poczatek = poczatek;
	}

	public Date getKoniec() {
		return koniec;
	}

	public void setKoniec(Date koniec) {
		this.koniec = koniec;
	}

	public Date getDzien() {
		return dzien;
	}

	public void setDzien(Date dzien) {
		this.dzien = dzien;
	}

	public String getKort() {
		return kort;
	}

	public void setKort(String kort) {
		this.kort = kort;
	}

	public Boolean getDostepna() {
		return dostepna;
	}

	public void setDostepna(Boolean dostepna) {
		this.dostepna = dostepna;
	}

	public Boolean getWykorzystana() {
		return wykorzystana;
	}

	public void setWykorzystana(Boolean wykorzystana) {
		this.wykorzystana = wykorzystana;
	}

	public Boolean getZawody() {
		return zawody;
	}

	public void setZawody(Boolean zawody) {
		this.zawody = zawody;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

}
