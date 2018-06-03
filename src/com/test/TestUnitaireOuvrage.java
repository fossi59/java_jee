package com.test;

import java.util.List;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.objetDao.IOuvrageDao;
import com.objetDaoImpl.IOuvrageDaoImpl;

import objetJava.Ouvrage;
import objetJava.Personne;

public class TestUnitaireOuvrage {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
IOuvrageDao obj = new IOuvrageDaoImpl();
//inserer donnees
Ouvrage p = new Ouvrage();

p.setTypeOuvrage("fondation");
p.setDateDebut('2001-12-23');
p.setDateFin(2002-01-11);
p.setIdTypeOuvrage(1);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);

p.setTypeOuvrage("assainissement");
p.setDateDebut(2001-12-15);
p.setDateFin(2002-01-02);
p.setIdTypeOuvrage(1);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);

p.setTypeOuvrage("charpente");
p.setDateDebut(2002-02-23);
p.setDateFin(2002-03-11);
p.setIdTypeOuvrage(1);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);

p.setTypeOuvrage("isolation");
p.setDateDebut(2001-12-23);
p.setDateFin(2002-01-11);
p.setIdTypeOuvrage(2);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);

p.setTypeOuvrage("plomberie");
p.setDateDebut(df.parse(2001-12-15);
p.setDateFin(df.parse(2002-01-02);
p.setIdTypeOuvrage(2);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);

p.setTypeOuvrage("charpente");
p.setDateDebut(df.parse(2002-02-23);
p.setDateFin(df.parse(2002-03-11);
p.setIdTypeOuvrage(1);
p.setIdEntrepreneur(1);
obj.addOuvrage(p);



	}

}
