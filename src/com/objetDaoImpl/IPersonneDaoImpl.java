package com.objetDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connexion.Connexion;

import com.objetDao.IPersonneDao;

import objetJava.Personne;

public class IPersonneDaoImpl implements IPersonneDao{

	@Override
	public void addPersonne(Personne p) {
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("insert into personne(IdPersonne,nom,prenom,sexe,situationMaritale,numRue,nomRue,codePostal,ville,pays) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, p.getIdPersonne());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.setString(4, p.getSexe());
			ps.setString(5, p.getSituationMaritale());
			ps.setInt(6, p.getNumRue());
			ps.setString(7, p.getNomRue());
			ps.setInt(8, p.getCodePostal());
			ps.setString(9, p.getVille());
			ps.setString(10, p.getPays());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void deletePersonne(int idPersonne) {
		Connection cnx = Connexion.connection();
		try {
			//
			PreparedStatement ps = cnx.prepareStatement("delete from personne where idPersonne = ?");
			ps.setInt(1, idPersonne);
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public Personne readPersonne(int idPersonne) {
		Personne p = null;
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from personne where idPersonne LIKE ?");
			ps.setInt(1, idPersonne);
			ResultSet res = ps.executeQuery();
			//si produit existe on fait ce qui suit
			if(res.next()) {
				p=new Personne();
				p.setIdPersonne(res.getInt("IdPersonne"));
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setSexe(res.getString("sexe"));
				p.setSituationMaritale(res.getString("situationMaritale"));
				p.setNumRue(res.getInt("numRue"));
				p.setNomRue(res.getString("nomRue"));
				p.setCodePostal(res.getInt("codePostal"));
				p.setVille(res.getString("ville"));
				p.setPays(res.getString("pays"));
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//si pesonne p n'existe pas on génére une exception
		if(p==null)throw new RuntimeException("personne"+idPersonne+" introuvable");
		return p;
	}

	@Override
	public void updatePersonne(Personne p, int idPers) {
		Connection cnx = Connexion.connection();
		try {
			//on ne peut pas mettre la clé primaire à jour
			PreparedStatement ps = cnx.prepareStatement("update personne set nom=?, prenom=?, sexe=?, situationMaritale=?, numRue=?, nomRue=?,codePostal=?, ville=?, pays=? where idPersonne =?");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getSexe());
			ps.setString(4, p.getSituationMaritale());
			ps.setInt(5, p.getNumRue());
			ps.setString(6, p.getNomRue());
			ps.setInt(7, p.getCodePostal());
			ps.setString(8, p.getVille());
			ps.setString(9, p.getPays());
			ps.setInt(10, idPers);
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<Personne> listePersonnesByMc(String mc) {
		List<Personne> personnes = new ArrayList<>();
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select*from personne where nom LIKE?");
			ps.setString(1, mc);
			ResultSet res = ps.executeQuery();
			//on fait du mapping objet relationnel
			while(res.next()) {
				Personne p = new Personne ();
				p.setIdPersonne(res.getInt("IdPersonne"));
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setSexe(res.getString("sexe"));
				p.setSituationMaritale(res.getString("situationMaritale"));
				p.setNumRue(res.getInt("numRue"));
				p.setNomRue(res.getString("nomRue"));
				p.setCodePostal(res.getInt("codePostal"));
				p.setVille(res.getString("ville"));
				p.setPays(res.getString("pays"));
				personnes.add(p);
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return personnes;
	}

	@Override
	public List<Personne> listePersonne() {
		List<Personne> personnes = new ArrayList<>();
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select*from personne");
			ResultSet res = ps.executeQuery();
			//on fait du mapping objet relationnel
			while(res.next()) {
				Personne p = new Personne ();
				p.setIdPersonne(res.getInt("IdPersonne"));
				p.setNom(res.getString("nom"));
				p.setPrenom(res.getString("prenom"));
				p.setSexe(res.getString("sexe"));
				p.setSituationMaritale(res.getString("situationMaritale"));
				p.setNumRue(res.getInt("numRue"));
				p.setNomRue(res.getString("nomRue"));
				p.setCodePostal(res.getInt("codePostal"));
				p.setVille(res.getString("ville"));
				p.setPays(res.getString("pays"));
				personnes.add(p);
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return personnes;
	}

	@Override
	public void updatePersonne(Personne p) {
		// TODO Auto-generated method stub
		
	}
	

}
