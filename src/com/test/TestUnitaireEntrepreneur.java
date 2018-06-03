package com.test;

import com.objetDao.IEntrepreneurDao;
import com.objetDaoImpl.IEntrepreneurDaoImpl;
import objetJava.Entrepreneur;

public class TestUnitaireEntrepreneur {
	public static void main(String[] args) {
	IEntrepreneurDao obj = new IEntrepreneurDaoImpl();
	obj.addEntrepreneur(new Entrepreneur("defoss",2));
	}

}
