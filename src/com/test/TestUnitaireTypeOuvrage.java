package com.test;

import com.objetDao.ITypeOuvrageDao;
import com.objetDaoImpl.ITypeOuvrageDaoImpl;
import objetJava.TypeOuvrage;

public class TestUnitaireTypeOuvrage {

	public static void main(String[] args) {
		ITypeOuvrageDao obj = new ITypeOuvrageDaoImpl();
		obj.addTypeOuvrage(new TypeOuvrage("gros oeuvre"));
		obj.addTypeOuvrage(new TypeOuvrage("second oeuvre"));
		obj.addTypeOuvrage(new TypeOuvrage("finition"));

	}

}
