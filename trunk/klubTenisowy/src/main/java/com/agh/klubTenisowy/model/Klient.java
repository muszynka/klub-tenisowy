package com.agh.klubTenisowy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Klient")
public class Klient {
	@Id
	@GeneratedValue
	private Integer id;
	private String imie;
	private String nazwisko;
	private String email;
	private String nrTel;
	private String rabat;
	private String rola;
	private String haslo;
	@OneToMany(mappedBy="klient")
	private Set<Rezerwacja> rezerwacje = new HashSet<Rezerwacja>();
	
	public Set<Rezerwacja> getRezerwacje() {
		return rezerwacje;
	}
	public void setRezerwacje(Set<Rezerwacja> rezerwacje) {
		this.rezerwacje = rezerwacje;
	}
	
	public Klient() {
		// TODO Auto-generated constructor stub
	}
	public Klient(String imie, String nazwisko, String email, String nrTel, String rabat, String rola,
			String haslo) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.nrTel = nrTel;
		this.rabat = rabat;
		this.rola = rola;
		this.haslo = haslo;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNrTel() {
		return nrTel;
	}

	public void setNrTel(String nrTel) {
		this.nrTel = nrTel;
	}

	public String getRabat() {
		return rabat;
	}

	public void setRabat(String rabat) {
		this.rabat = rabat;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	

}
