package com.agh.klubTenisowy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agh.klubTenisowy.model.KlubTenisowyModel;
import com.agh.klubTenisowy.model.Rezerwacja;

public class KlubTenisowy extends HttpServlet {

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
		String akcja = request.getParameter("Akcja");
		if (akcja != null) {
			if (akcja.equals("Rejestracja")) {
				rejestruj(request, response);
				return;
			}
			if (akcja.equals("Rezerwacja")) {
				rezerwuj(request, response);
				return;
			}
			if (akcja.equals("WidokRezerwacji")) {
				wyswietlRezerwacje(request, response);
				return;
			}

		}
	}

	private void wyswietlRezerwacje(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		KlubTenisowyModel klubTenisowyModel = new KlubTenisowyModel();
		List<Rezerwacja> dajRezerwacje = klubTenisowyModel.dajRezerwacje();
		System.out.println("REZERWACJE: = " + dajRezerwacje.size());
		request.setAttribute("Rezerwacje", dajRezerwacje);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Rezerwacje.jsp");
		requestDispatcher.forward(request, response);
		// TODO Auto-generated method stub

	}

	private void rezerwuj(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("rezerwacja");
		String email = request.getParameter("Email");
		String haslo = request.getParameter("Haslo");
		String idRezerwacji = request.getParameter("IdRezerwacji");
		KlubTenisowyModel klubTenisowyModel = new KlubTenisowyModel();
		String dokonajRezerwacjiOdpowiedz = klubTenisowyModel.dokonajRezerwacji(email, haslo, idRezerwacji);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html> <body>" + dokonajRezerwacjiOdpowiedz + "</body></html>");

	}

	private void rejestruj(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imie = request.getParameter("Imie");
		String nazwisko = request.getParameter("Nazwisko");
		String email = request.getParameter("Email");
		String nrTel = request.getParameter("NrTel");
		String haslo = request.getParameter("Haslo");
		KlubTenisowyModel klubTenisowyModel = new KlubTenisowyModel();
		String rejestrujKlientaOdpowiedz = klubTenisowyModel.rejestrujKlienta(imie, nazwisko, email, nrTel,
				haslo);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html> <body>" + rejestrujKlientaOdpowiedz + "</body></html>");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		String akcja = request.getParameter("Akcja");
		if (akcja != null)
			if (akcja.equals("WidokRezerwacji")) {
				wyswietlRezerwacje(request, response);
				return;
			}
	}
}
