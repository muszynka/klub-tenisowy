package com.agh.klubTenisowy.dao;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.agh.klubTenisowy.model.Klient;
import com.agh.klubTenisowy.model.Rezerwacja;

public class HibernateDao {

	public Session getSession() {
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		Session openSession = (annotationConfiguration.configure(new File(
				"../server/default/lib/hibernate.cfg.xml")).buildSessionFactory()).openSession();
		return openSession;
	}

	public Klient rejestrujKlienta(String imie, String nazwisko, String email, String nrTel, String haslo)
			{
		Session session = (new HibernateDao()).getSession();
		session.beginTransaction();
		Klient klient = new Klient(imie, nazwisko, email, nrTel, "0", "client", haslo);
		session.saveOrUpdate(klient);
		session.getTransaction().commit();
		session.close();
		return klient;
	}

	public List<Klient> znajdzKlientow(String email, String haslo) {
		Session openSession = getSession();
		Criteria createCriteria = openSession.createCriteria(Klient.class);
		createCriteria.add(Restrictions.eq("email", email));
		createCriteria.add(Restrictions.eq("haslo", haslo));
		List list = createCriteria.list();
		openSession.close();
		return list;
	}

	public Rezerwacja znajdzRezerwacje(int id) {
		Session openSession = getSession();
		Criteria createCriteria = openSession.createCriteria(Rezerwacja.class);
		createCriteria.add(Restrictions.eq("id", id));
		Rezerwacja rezerwacja = (Rezerwacja)createCriteria.uniqueResult();
		openSession.close();
		return rezerwacja;
	}

	public Rezerwacja uaktywnijRezerwacje(Klient klient, int id) {
		Rezerwacja rezerwacja = znajdzRezerwacje(id);
		Session openSession = getSession();
		openSession.beginTransaction();
		if (rezerwacja != null) {
			rezerwacja.setKlient(klient);
			rezerwacja.setDostepna(false);
			openSession.update(klient);
			klient.getRezerwacje().add(rezerwacja);
			openSession.saveOrUpdate(klient);
			openSession.saveOrUpdate(rezerwacja);
		}
		openSession.getTransaction().commit();
		openSession.close();
		return rezerwacja;

	}

	public List<Rezerwacja> dajRezerwacje() {
		Session openSession = getSession();
		Criteria createCriteria = openSession.createCriteria(Rezerwacja.class);
		List list = createCriteria.list();
		openSession.close();
		return list;
		
	}

	public Rezerwacja dodajRezerwacje(Date poczatek, Date koniec, Date dzien, String kort) {
		Session session = (new HibernateDao()).getSession();
		session.beginTransaction();
		Rezerwacja rezerwacja = new Rezerwacja(poczatek, koniec,dzien,kort);
		session.saveOrUpdate(rezerwacja);
		session.getTransaction().commit();
		session.close();
		return rezerwacja;
	}

	
	
	
	
	/*	public Rezerwacja utworzRezerwacje(Klient klient, String poczatek, String koniec, String kort) {
			Session openSession = getSession();
			openSession.beginTransaction();
			Rezerwacja rezerwacja = new Rezerwacja(poczatek, koniec, kort, true, false, false, klient);
			klient.getRezerwacje().add(rezerwacja);
			rezerwacja.setKlient(klient);
			openSession.saveOrUpdate(klient);
			openSession.saveOrUpdate(rezerwacja);
			openSession.getTransaction().commit();
			openSession.close();
			return rezerwacja;
		}
	*/
}
