package com.agh.klubTenisowy.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.agh.klubTenisowy.dao.HibernateDao;

public class KlubTenisowyModel {

	public String dokonajRezerwacji(String email, String haslo, String idRezerwacji) {

		List<Klient> list = new HibernateDao().znajdzKlientow(email, haslo);
		if (list == null || list.size() == 0) {
			return "Podany login lub haslo jest nieprawidlowe.";
		} else {
			Rezerwacja znajdzRezerwacjeOdpowiedz = new HibernateDao().znajdzRezerwacje(Integer
					.valueOf(idRezerwacji));
			if (znajdzRezerwacjeOdpowiedz != null && znajdzRezerwacjeOdpowiedz.getDostepna() == false) {
				return "Rezerwacja nie jest dostepna.";
			}
			Rezerwacja uaktywnijRezerwacje = new HibernateDao().uaktywnijRezerwacje(list.get(0),
					Integer.valueOf(idRezerwacji));
			if (uaktywnijRezerwacje == null) {
				return "Wystapil problem przy rezerwacji. Sprobuj ponownie.";
			} else
				return "Dziekujemy za rezerwacje.";

		}
	}

	public String rejestrujKlienta(String imie, String nazwisko, String email, String nrTel, String haslo) {
		if (email == null || email.trim().equals("") || haslo == null || haslo.trim().equals("")) {
			return "Email lub haslo jest nieprawidlowe.";
		}

		List<Klient> znajdzKlientow = new HibernateDao().znajdzKlientow(email, haslo);
		if (znajdzKlientow != null && znajdzKlientow.size() > 0) {
			return "Klient o podanym emailu juz istnieje. ";
		}
		Klient rejestrujKlientaOdpowiedz = new HibernateDao().rejestrujKlienta(imie, nazwisko, email, nrTel,
				haslo);
		if (rejestrujKlientaOdpowiedz == null) {
			return "Wystapil problem przy rejestracji. Sprobuj ponownie.";
		} else
			return "Dziekujemy za rejestracje.";
	}

	public List<Rezerwacja> dajRezerwacje() {
		return new HibernateDao().dajRezerwacje();

	}

}
