package com.metier.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.model.Professeur;

import org.hibernate.Query;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 
public class ProfesseurDoa {

	Connection connection;

	

	public void saveProfesseur(String nom, int age,String prenom) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Professeur per = new Professeur();
			per.setNom(nom);
			per.setPreNom(prenom);
			per.setAge(age);
			session.save(per);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Professeur> getProfesseur() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from Professeur");
		List<Professeur> per = query.list();
		 

		session.close();
		return per.stream() 
                .collect(Collectors.toList());
	}

	public Professeur getPers(int id) {
		Session session = HibernateUtil.getSession();
		Professeur Professeur = session.get(Professeur.class, id);
		return Professeur;
	}

	public void updateProfesseur(int id, Professeur per) {

		Session session = HibernateUtil.getSession();
		 Transaction tx = session.beginTransaction();
		Professeur Professeur = session.load(Professeur.class, id);
//		Professeur.set(id);
		Professeur.setPreNom(per.getPreNom());
		Professeur.setNom(per.getNom());
//		session.update(Professeur);
		tx.commit();
		session.close();
 

	}

	public int deleteProfesseur(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Professeur where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

}
