package com.objetDao;

import java.util.List;

import objetJava.Entrepreneur;

public interface IEntrepreneurDao {
	
	
	//methode pour ajouter un entrepreneur qui prend en parametre un entrepreneur e
		public void addEntrepreneur (Entrepreneur e);
		
		//methode pour supprimer une personne
		public void deleteEntrepreneur (int idEntrepreneur);
		
		//methode pour consulter un entrepreneur qui prend en parametre la reference de l'entrepreneur pour
		//retourner l'identité de la personne
		public Entrepreneur readEntrepreneur (int idEntrepreneur);
		
		//methode pour modifier une personne
		public void updateEntrepreneur (Entrepreneur e);
		
		//methode pour consulter les entrepreneurs par un mot clé
		List<Entrepreneur>listeEntrepreneur ();
		
		

}
