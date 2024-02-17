package com.metier.dao;

import java.util.List;

import com.metier.model.Professeur;

public interface Dao  {

	List<Professeur> aProfesseurne();

	Professeur getById(int id);

	void sauvgarde(String nom,String prenom,int age );

	void modifier(Professeur pers );

	void suprimer(int t);
}