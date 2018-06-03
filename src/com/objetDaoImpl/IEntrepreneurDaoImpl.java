package com.objetDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connexion.Connexion;
import com.objetDao.IEntrepreneurDao;

import objetJava.Entrepreneur;

public class IEntrepreneurDaoImpl implements IEntrepreneurDao{

	@Override
	public void addEntrepreneur(Entrepreneur e) {
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("insert into entrepreneur(IdEntrepreneur,nomEntreprise,idPersonne) values(?,?,?)");
			ps.setInt(1, e.getIdEntrepreneur());
			ps.setString(2, e.getNomEntreprise());
			ps.setInt(3, e.getIdPersonne());
			
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
	}

	@Override
	public void deleteEntrepreneur(int idEntrepreneur) {
		Connection cnx = Connexion.connection();
		try {
			//
			PreparedStatement ps = cnx.prepareStatement("delete from entrepreneur where idEntrepreneur = ?");
			ps.setInt(1, idEntrepreneur);
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public Entrepreneur readEntrepreneur(int idEntrepreneur) {
		Entrepreneur e = null;
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from entrepreneur,personne where personne.idPersonne=entrepreneur.idPersonne and idEntrepreneur = "+idEntrepreneur);
			ps.setInt(1, idEntrepreneur);
			ResultSet res = ps.executeQuery();
			//si entrepreneur existe on fait ce qui suit
			if(res.next()) {
				e=new Entrepreneur();
				e.setIdEntrepreneur(res.getInt("IdEntrepreneur"));
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		//si  p n'existe pas on génére une exception
		if(e==null)throw new RuntimeException("entrepreneur"+idEntrepreneur+" introuvable");
		return e;
	}

	@Override
	public void updateEntrepreneur(Entrepreneur e) {
		Connection cnx = Connexion.connection();
		try {
			//on ne peut pas mettre la clé primaire à jour
			PreparedStatement ps = cnx.prepareStatement("update entrepreneur set nomEntreprise=? where idEntrepreneur =? and idPersonne = ?");
			ps.setString(1, e.getNomEntreprise());
			ps.setInt(2, e.getIdEntrepreneur());
			ps.setInt(3, e.getIdPersonne());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public List<Entrepreneur> listeEntrepreneur() {
		List<Entrepreneur> entrepreneurs = new ArrayList<>();
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select*from entrepreneur");
			ResultSet res = ps.executeQuery();
			//on fait du mapping objet relationnel
			while(res.next()) {
				Entrepreneur e = new Entrepreneur ();
				e.setIdEntrepreneur(res.getInt("IdEntrepreneur"));
				e.setNomEntreprise(res.getString("nomEntreprise"));
				e.setIdPersonne(res.getInt("idPersonne"));
				entrepreneurs.add(e);
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		return entrepreneurs;
	}

}
