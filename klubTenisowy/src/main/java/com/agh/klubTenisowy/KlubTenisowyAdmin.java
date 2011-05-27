package com.agh.klubTenisowy;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.classic.Session;

import com.agh.klubTenisowy.dao.HibernateDao;
import com.agh.klubTenisowy.model.Klient;
import com.agh.klubTenisowy.model.KlubTenisowyModel;
import com.agh.klubTenisowy.model.Rezerwacja;

public class KlubTenisowyAdmin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3059758052324443970L;

	/**
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String akcja = request.getParameter("akcja");
		if (akcja != null) {
			if (akcja.equals("wypelnijRejestracje")) {
				wypelnijRejestracje(request, response);
				return;
			}

		}

	}

	private void wypelnijRejestracje(HttpServletRequest request, HttpServletResponse response) {
		try {
			HibernateDao hibernateDao = new HibernateDao();
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-DD HH:mm:ss");
			hibernateDao.dodajRezerwacje(sdf.parse("2011-07-01 08:00:00"), sdf.parse("2011-07-01 09:00:00"),
					sdf.parse("2011-07-01 08:00:00"), "1");
			hibernateDao.dodajRezerwacje(sdf.parse("2011-07-01 09:00:00"), sdf.parse("2011-07-01 10:00:00"),
					sdf.parse("2011-07-01 08:00:00"), "1");
			hibernateDao.dodajRezerwacje(sdf.parse("2011-07-01 10:00:00"), sdf.parse("2011-07-01 11:00:00"),
					sdf.parse("2011-07-01 08:00:00"), "1");
			hibernateDao.dodajRezerwacje(sdf.parse("2011-07-01 11:00:00"), sdf.parse("2011-07-01 12:00:00"),
					sdf.parse("2011-07-01 08:00:00"), "1");
			hibernateDao.dodajRezerwacje(sdf.parse("2011-07-01 12:00:00"), sdf.parse("2011-07-01 13:00:00"),
					sdf.parse("2011-07-01 08:00:00"), "1");
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}