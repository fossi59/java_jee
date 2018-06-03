package com.objetDao;

import java.sql.Date;
import java.util.List;

import objetJava.Ouvrage;

public interface IOuvrageDao {
	
	//methode pour ajouter un ouvrage qui prend en parametre un ouvrage
			public void addOuvrage (Ouvrage o);
			
			//methode pour supprimer un ouvrage
			public void deleteOuvrage (int idOuvrage);
			
			//methode pour consulter un ouvrage qui prend en parametre la reference de l'ouvrage pour
			//retourner le type d'ouvrage et le nom de l'entrepreneur en charge de le faire
			public Ouvrage readOuvrage (int idOuvrage);
			
			//methode pour modifier un ouvrage
			public void updateOuvrage (Ouvrage o);
			
			//methode pour consulter la liste d'ouvrage par un mot clé
			List<Ouvrage>listeOuvragesByMc (String mc);
			
			//methode pour consulter les ouvrages selon une date donnée
			List<Ouvrage>listeOuvrageByDate(Date dt);
			
			//methode pour consulter le nombre d'ouvrage par entrepreneur
			public int nbreouvragebyentreprenseur (int nombre);
}
