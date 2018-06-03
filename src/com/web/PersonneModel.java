package com.web;

import java.util.ArrayList;
import java.util.List;

import objetJava.Personne;

public class PersonneModel {
private String motCle;
private Personne personne = new Personne();
private String erreur;
private String mode ="ajout";
private List<Personne>listpesonne= new ArrayList<>();
public String getMotCle() {
	return motCle;
}
public void setMotCle(String motCle) {
	this.motCle = motCle;
}
public List<Personne> getListpesonne() {
	return listpesonne;
}
public void setListpesonne(List<Personne> listpesonne) {
	this.listpesonne = listpesonne;
}
public Personne getPersonne() {
	return personne;
}
public void setPersonne(Personne personne) {
	this.personne = personne;
}
public String getErreur() {
	return erreur;
}
public void setErreur(String erreur) {
	this.erreur = erreur;
}
public String getMode() {
	return mode;
}
public void setMode(String mode) {
	this.mode = mode;
}
}
