package com.objetDaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connexion.Connexion;
import com.objetDao.IOuvrageDao;

import objetJava.Ouvrage;

public class IOuvrageDaoImpl implements IOuvrageDao{

	@Override
	public void addOuvrage(Ouvrage o) {
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("insert into ouvrage(IdOuvrage,typeOuvrage,dateDebut,dateFin,idEntrepreneur,IdTypeOuvrage) values(?,?,?,?,?,?)");
			ps.setInt(1, o.getIdOuvrage());
			ps.setString(2, o.getTypeOuvrage());
			ps.setDate(3, o.getDateDebut());
			ps.setDate(4, o.getDateFin());
			ps.setInt(5, o.getIdEntrepreneur());
			ps.setInt(6, o.getIdTypeOuvrage());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public void deleteOuvrage(int idOuvrage) {
		Connection cnx = Connexion.connection();
		try {
			//
			PreparedStatement ps = cnx.prepareStatement("delete from ouvrage where idOuvrage =?");
			ps.setInt(1, idOuvrage);
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public Ouvrage readOuvrage(int idOuvrage) {
		Ouvrage o = null;
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from ouvrage,entrepreneur,type_ouvrage where ouvrage.idEntrepreneur=entrepreneur.idEntrepreneur and ouvrage.IdTypeOuvrage = type_ouvrage.idTypeOuvrage and idOuvrage = "+idOuvrage);
			ps.setInt(1, idOuvrage);
			ResultSet res = ps.executeQuery();
			//si ouvrage existe on fait ce qui suit
			if(res.next()) {
				o=new Ouvrage();
				o.setIdOuvrage(res.getInt("IdOuvrage"));
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		//si pesonne p n'existe pas on génére une exception
		if(o==null)throw new RuntimeException("ouvrage"+idOuvrage+" introuvable");
		return o;
	}

	@Override
	public void updateOuvrage(Ouvrage o) {
		Connection cnx = Connexion.connection();
		try {
			//on ne peut pas mettre la clé primaire à jour
			PreparedStatement ps = cnx.prepareStatement("update ouvrage set typeOuvrage=?, dateDebut=?, dateFin = ? where idOuvrage= ? and idEntrepreneur =? and idTypeOuvrage = ?");
			ps.setString(1, o.getTypeOuvrage());
			ps.setDate(2, (Date) o.getDateDebut());
			ps.setDate(3, (Date) o.getDateFin());
			ps.setInt(4, o.getIdOuvrage());
			ps.setInt(5, o.getIdEntrepreneur());
			ps.setInt(6, o.getIdTypeOuvrage());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public List<Ouvrage> listeOuvragesByMc(String mc) {
		List<Ouvrage> ouvrages = new ArrayList<>();
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from ouvrage,entrepreneur where ouvrage.idEntrepreneur = entrepreneur.idEntrepreneur and nomEntreprise LIKE ? ");
			ps.setString(1, mc);
			ResultSet res = ps.executeQuery();
			//on fait du mapping objet relationnel
			while(res.next()) {
				Ouvrage p = new Ouvrage ();
				p.setIdOuvrage(res.getInt("IdOuvrage"));
				p.setTypeOuvrage(res.getString("typeOuvrage"));
				p.setDateDebut(res.getDate("dateDebut"));
				p.setDateFin(res.getDate("dateFin"));
				p.setIdEntrepreneur(res.getInt("idEntrepreneur"));
				p.setIdTypeOuvrage(res.getInt("idTypeOuvrage"));
				
				ouvrages.add(p);
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ouvrages;
	}

	@Override
	public List<Ouvrage>listeOuvrageByDate(Date dt){
		List<Ouvrage> ouvrages = new ArrayList<>();
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select * from ouvrage where dateDebut<="+ dt+ "and dateFin>="+dt);
			ps.setDate(1, dt);
			ResultSet res = ps.executeQuery();
			//on fait du mapping objet relationnel
			while(res.next()) {
				Ouvrage p = new Ouvrage ();
				p.setIdOuvrage(res.getInt("IdOuvrage"));
				p.setTypeOuvrage(res.getString("typeOuvrage"));
				p.setDateDebut(res.getDate("dateDebut"));
				p.setDateFin(res.getDate("dateFin"));
				p.setIdEntrepreneur(res.getInt("idEntrepreneur"));
				p.setIdTypeOuvrage(res.getInt("idTypeOuvrage"));
				
				ouvrages.add(p);
				
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ouvrages;
	}
	
	//Comptabiliser tous les ouvrages réalisés par un entrepreneur donné.
	@Override
	public int nbreouvragebyentreprenseur(int nombre) {
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("select count (*) as 'nombre ouvrage' from ouvrage,entrepreneur Group by nomEntreprise where ouvrage.idEntrepreneur=entrepreneur.idEntrepreneur  and 'nombre ouvrage' = "+nombre);
			ps.setInt(1, nombre);
			ResultSet res = ps.executeQuery();
			//si ouvrage existe on fait ce qui suit
			if(res.next()) {
				return nombre;
			}
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		//si pesonne p n'existe pas on génére une exception
		if(nombre==0)throw new RuntimeException("nombre d'ouvrage trouvé"+nombre);
		return 0;
	}

}
