package com.objetDao;

import objetJava.TypeOuvrage;

public interface ITypeOuvrageDao {
	
	//methode pour ajouter un type d'ouvrage qui prend en parametre un type d'ouvrage
		public void addTypeOuvrage (TypeOuvrage t);
		
		//methode pour supprimer un type d'ouvrage
		public void deleteTypeOuvrage (int idTypeOuvrage);
		
		
		//methode pour modifier un type d'ouvrage
		public void updateTypeOuvrage (TypeOuvrage t);
		
		
}
