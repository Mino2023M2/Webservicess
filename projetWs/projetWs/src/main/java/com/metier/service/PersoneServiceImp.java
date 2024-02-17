package com.metier.service;

import java.util.ArrayList;
import java.util.List;
 
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import com.metier.dao.ProfesseurDoa;
import com.metier.model.Professeur;

@WebService(name="ProfesseurService")
public class PersoneServiceImp  {
	ProfesseurDoa pdo = new ProfesseurDoa();

	 
	@WebMethod(operationName = "ajouterProfesseur")
	public void addPerson(
			@WebParam(name = "nom")
			String nom,
			@WebParam(name = "prenom")
			String prenom,
			@WebParam(name = "age") 
			int age) {
		// TODO Auto-generated method stub
		pdo.saveProfesseur(nom, age, prenom);
	}

	 
	@WebMethod
	public Professeur getPerson(int var1) {
		Professeur Professeur = pdo.getPers(var1);
		return Professeur;
	}
 
	@WebMethod
	public List<Professeur> getAllPersons() {
		List<Professeur> list = new ArrayList<Professeur>();
		list = pdo.getProfesseur();
		return list;
	}
 
	@WebMethod
	public void updatePerson(Professeur var1) {
		Professeur per = new Professeur();
		per.setAge(var1.getAge());
		per.setNom(var1.getNom());
		per.setPreNom(var1.getPreNom());
		pdo.updateProfesseur(var1.getId(), per);
	}
 
	@WebMethod
	public void deletePerson(int var1) {
		pdo.deleteProfesseur(var1);
	}

}
