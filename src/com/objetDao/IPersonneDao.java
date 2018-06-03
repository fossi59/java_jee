package com.objetDao;

import java.util.List;

import objetJava.Personne;

public interface IPersonneDao {
	//methode pour ajouter une pesonne qui prend en parametre une pesonne
	public void addPersonne (Personne p);
	
	//methode pour modifier une personne
	public void deletePersonne (int idPersonne);
	
	//methode pour consulter une personne qui prend en parametre la reference de la pesonne pour
	//retourner l'identité de la personne
	public Personne readPersonne (int idPersonne);
	
	//methode pour modifier une personne
	public void updatePersonne (Personne p);
	
	//methode pour consulter les personnes par un mot clé
	List<Personne>listePersonnesByMc (String mc);
	
	//methode pour consulter toutes les pesonnes
	List<Personne>listePersonne();

	void updatePersonne(Personne p, int idPers);

}
