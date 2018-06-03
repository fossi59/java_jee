package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objetDao.IPersonneDao;
import com.objetDaoImpl.IPersonneDaoImpl;

import objetJava.Personne;

/**
 * Servlet implementation class Servlet
 */
@SuppressWarnings("serial")
@WebServlet("/Servlet")
public class ControleurServlet extends HttpServlet {
    /**
     dans le servlet on a besoin de la couche metier
     donc on va declarer un objet de type inteface metier
     */
	private IPersonneDao metier;
	
	//on aura besoin de methode init() pour charger le servlet en memoire
	public void init() {
		//on va lier la couche metier au controleur
		metier = new IPersonneDaoImpl();
	}

	/**
	 * qd on appelle le controleur il nous retoune la vue grace à "request.getRequestDispatcher("nom de la jsp(vue)").forward(
	 * request, response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// la methode doget appelle la methode dopost
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on introduit le model (M), une classe qui permet de stocker les données qu'on va saisir et
		//les resultats qu'on va afficher. Alors on va creer une classe dans la couche web
		
		//qd on envoie une requete au controleur, il va creer un model
		PersonneModel model = new PersonneModel();
		//on va rechercher un parametre donné exemple:action
		String action = request.getParameter("action");
		
		if(action!=null) {
			if(action.equals("Recherche")) {
				
				//le model va stocker les données saisir dans la jsp, grace a "request.getParameter("nom du champ dans la jsp")
				model.setMotCle(request.getParameter("motcle"));
				String mc=model.getMotCle();
				//le controleur va renvoyer une liste de pesonne via la couche metier
				List<Personne> personnes = metier.listePersonnesByMc("%"+mc+"%");
				
				//il faut now stocker les resultats dans le model 
				model.setListpesonne(personnes);
				
				//il faut now stocker les resultats dans l'objet request, qui 2 parametre(le nom de l'objet, et l'objet)
				request.setAttribute("model", model);
			}
			
			else if(action.equals("delete")) {
				int id=Integer.parseInt(request.getParameter("ref"));
				metier.deletePersonne(id);
				model.setListpesonne(metier.listePersonne());
				request.setAttribute("model", model);
			}
		else if(action.equals("save")) {
			
			model.getPersonne().setNom(request.getParameter("nom"));
			model.getPersonne().setPrenom(request.getParameter("prenom"));
			model.getPersonne().setSexe(request.getParameter("sexe"));
			model.getPersonne().setSituationMaritale(request.getParameter("situationMaritale"));
			model.getPersonne().setNumRue(Integer.parseInt(request.getParameter("numRue")));
			model.getPersonne().setNomRue(request.getParameter("nomRue"));
			model.getPersonne().setCodePostal(Integer.parseInt(request.getParameter("codePostal")));
			model.getPersonne().setVille(request.getParameter("ville"));
			model.getPersonne().setPays(request.getParameter("pays"));
			
			metier.addPersonne(model.getPersonne());
			model.setListpesonne(metier.listePersonne());
			request.setAttribute("model", model);
			
		}else if(action.equals("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Personne p =metier.readPersonne(id);
			model.setPersonne(p);
			
			model.setListpesonne(metier.listePersonne());
			request.setAttribute("model", model);
			
		}else if(action.equals("update")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom= request.getParameter("prenom");
			String sexe = request.getParameter("sexe");
			String situationMaritale = request.getParameter("situationMaritale");
			int numRue = Integer.parseInt(request.getParameter("numRue"));
			String nomRue = request.getParameter("nomRue");
			int codePostal = Integer.parseInt(request.getParameter("codePostal"));
			String ville = request.getParameter("ville");
			String pays = request.getParameter("pays");
			Personne p = new Personne(nom,prenom,sexe,situationMaritale, numRue, nomRue, codePostal, ville, pays);
			
			metier.updatePersonne(p, id);
			model.setListpesonne(metier.listePersonne());
			request.setAttribute("model", model);}
		
		
		//le controleur recupere la vue pour afficher le resultat
		request.getRequestDispatcher("VuePersonne.jsp").forward(request, response);
		//pour afficher les produits dans la jsp, il faut creer une table dans la jsp.
		
		
	}

}
}