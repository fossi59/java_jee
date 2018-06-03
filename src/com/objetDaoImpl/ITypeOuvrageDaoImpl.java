package com.objetDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connexion.Connexion;
import com.objetDao.ITypeOuvrageDao;

import objetJava.TypeOuvrage;

public class ITypeOuvrageDaoImpl implements ITypeOuvrageDao{

	@Override
	public void addTypeOuvrage(TypeOuvrage t) {
		Connection cnx = Connexion.connection();
		try {
			PreparedStatement ps = cnx.prepareStatement("insert into type_ouvrage(IdTypeOuvrage,nomTypeOuvrage) values(?,?)");
			ps.setInt(1, t.getIdTypeOuvrage());
			ps.setString(2, t.getNomTypeOuvrage());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public void deleteTypeOuvrage(int idTypeOuvrage) {
		Connection cnx = Connexion.connection();
		try {
			//
			PreparedStatement ps = cnx.prepareStatement("delete from type_ouvrage where idTypeOuvrage =?");
			ps.setInt(1, idTypeOuvrage);
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

	@Override
	public void updateTypeOuvrage(TypeOuvrage t) {
		Connection cnx = Connexion.connection();
		try {
			//on ne peut pas mettre la clé primaire à jour
			PreparedStatement ps = cnx.prepareStatement("update type_ouvrage set nomTypeOuvrage=?");
			ps.setString(1, t.getNomTypeOuvrage());
			ps.executeUpdate();
			//fermeture de l'objet preparedStatement
			ps.close();
		} catch (SQLException ev) {
			// TODO Auto-generated catch block
			ev.printStackTrace();
		} 
		
	}

}
