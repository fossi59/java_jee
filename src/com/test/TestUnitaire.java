package com.test;

import java.util.List;

import com.objetDao.IPersonneDao;
import com.objetDaoImpl.IPersonneDaoImpl;

import objetJava.Personne;

public class TestUnitaire {

	public static void main(String[] args) {
		IPersonneDao obj = new IPersonneDaoImpl();
		
		//ajouter personne
		obj.addPersonne(new Personne("Jean","François","Homme","Marié",67,"Bd Gambetta",59000,"Lille","France"));
		obj.addPersonne(new Personne("Paul","Henry","Homme","Marié",23,"Av Preta",59000,"Lille","France"));
		obj.addPersonne(new Personne("Pierre","Lecoq","Homme","Marié",11,"rue de la brise",59800,"Fives","France"));
		obj.addPersonne(new Personne("Pierrette","Deckezer","Femme","Marié",33,"Bd Langevin",59650,"Villeneuve d'Ascq","France"));
		obj.addPersonne(new Personne("Alexandre","Legrand","Homme","Celibataire",111,"Bd de l'Ouest",59000,"Lille","France"));
		obj.addPersonne(new Personne("Jean","François","Homme","Marié",67,"Bd Gambetta",59000,"Lille","France"));
		obj.addPersonne(new Personne("Paul","Mathieu","Homme","Celibataire",9,"rue de la Madeleine",59000,"Lille","France"));
		obj.addPersonne(new Personne("Marie","Paul","Femme","Marié",77,"Av Loung",59170,"Croix","France"));
		
		//supprimer personne
		obj.deletePersonne(2);
		
		//update personne
		Personne p = new Personne();
		p.setCodePostal(59170);
		p.setIdPersonne(2);
		p.setNom("Jean");
		p.setPrenom("Franck");
		p.setSexe("Homme");
		p.setSituationMaritale("Celibataire");
		p.setNomRue("rue colmar");
		p.setNumRue(65);
		p.setVille("Croix");
		p.setPays("France");
		obj.updatePersonne(p);
		
		//liste de toutes les personnes
		List<Personne>personnes = obj.listePersonne();
		for(Personne b:personnes){
			System.out.println(b.getNom()+" "+b.getPrenom()+" "+b.getSexe()+" "+b.getSituationMaritale()+" "+b.getNumRue()+" "+b.getNomRue()+" "+b.getCodePostal()+" "+b.getVille()+b.getPays());
		}
			//liste de personnes par mot clé
			List<Personne>personne = obj.listePersonnesByMc("Paul");
			for(Personne c:personne){
				System.out.println(c.getNom()+" "+c.getPrenom()+" "+c.getSexe()+" "+c.getSituationMaritale()+" "+c.getNumRue()+" "+c.getNomRue()+" "+c.getCodePostal()+" "+c.getVille()+c.getPays());
			
		}
		//lire une personne
		Personne r = obj.readPersonne(1);
		System.out.println(r.getNom()+" "+r.getPrenom()+" "+r.getSexe()+" "+r.getSituationMaritale()+" "+r.getNumRue()+" "+r.getNomRue()+" "+r.getCodePostal()+" "+r.getVille()+" "+r.getPays());
		
	
	//avant de mettre a jour une personne, il faut d'abord la consulter
		//consultation personn
		Personne s = obj.readPersonne(1);
		//modifier nom
		s.setNom("George");
		//update nom
		obj.updatePersonne(s);
		
		System.out.println(s.getNom()+" "+s.getPrenom()+" "+s.getSexe()+" "+s.getSituationMaritale()+" "+s.getNumRue()+" "+s.getNomRue()+" "+s.getCodePostal()+" "+s.getVille()+" "+s.getPays());
		
	}

}
