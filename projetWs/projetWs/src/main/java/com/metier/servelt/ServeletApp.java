package com.metier.servelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metier.dao.ProfesseurDoa;
import com.metier.model.Professeur;
import com.metier.service.PersoneServiceImp;

import jakarta.xml.ws.Endpoint;

/**
 * Servlet implementation class ServeletApp
 */
@WebServlet(name = "/ServeletApp", urlPatterns = { "/Service" })
public class ServeletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

//	String forward = "/WEB-INF/index2.jsp";
	String action;
	boolean update = false;
	PersoneServiceImp serviceImp = new PersoneServiceImp();
	/**
	 * Default constructor.
	 */
	private String accion;
	private int idUser;
	private String donnee;

	public ServeletApp() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		processRequest(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.accion = request.getParameter("accion") == null ? "listar" : request.getParameter("accion");

		switch (this.accion) {
		case "listar":
			List<Professeur> list = serviceImp.getAllPersons();
			request.setAttribute("donnee", list);
			request.getRequestDispatcher("/WEB-INF/users/index.jsp").forward(request, response);
			break;
		case "add":
			request.getRequestDispatcher("/WEB-INF/users/add.jsp").forward(request, response);
			break;
		case "insert":
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			int age = Integer.parseInt(request.getParameter("age"));

			serviceImp.addPerson(nom, prenom, age);
			request.setAttribute("donnee", donnee);
			response.sendRedirect("Service");
			break;
		case "edit":
			this.idUser = Integer.parseInt(request.getParameter("id"));
			Professeur persone = serviceImp.getPerson(idUser);
			request.setAttribute("usuario", persone);
			request.getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(request, response);
			break;
		case "modifier":
			int id = Integer.parseInt(request.getParameter("idUser"));
			String nom1 = request.getParameter("nom");
			String prenom1 = request.getParameter("prenom");
			int age1 = Integer.parseInt(request.getParameter("age"));
			Professeur per = new Professeur();
			per.setId(id);
			per.setAge(age1);
			per.setNom(nom1);
			per.setPreNom(prenom1);
			serviceImp.updatePerson(per);
			request.setAttribute("donnee", donnee);
			response.sendRedirect("Service");
			break;
		case "delete":
			this.idUser = Integer.parseInt(request.getParameter("id"));
			serviceImp.deletePerson(idUser);
			request.setAttribute("donnee", donnee);
			response.sendRedirect("Service");
			break;
		default:
			break;
		}
	}
}
