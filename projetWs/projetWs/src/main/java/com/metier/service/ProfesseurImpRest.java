package com.metier.service;

import com.metier.model.Professeur;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metier.dao.ProfesseurDoa;
@ApplicationPath(value = "Professeurs")
//@Path("/Professeurs")

@Consumes(MediaType.APPLICATION_JSON) 
@Produces(MediaType.APPLICATION_JSON)
public class ProfesseurImpRest extends Metadata{
	ProfesseurDoa pdo = new ProfesseurDoa();

	public ProfesseurImpRest() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersons() {

		List<Professeur> Professeurs = pdo.getProfesseur();

		// Return the list of Professeurs as JSON
		return Response.ok(Professeurs).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  updatePerson(@PathParam("id") int id, Professeur var1) {
		Professeur existingProfesseur = pdo.getPers(id); // Implement this method
		if (existingProfesseur != null) {

			Professeur per = new Professeur();
			per.setAge(var1.getAge());
			per.setNom(var1.getNom());
			per.setPreNom(var1.getPreNom());
			pdo.updateProfesseur(var1.getId(), per);

			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@DELETE
	@Path("/{id}")
	public Response  deletePerson(@PathParam("id") int var1) {
		Professeur existingProfesseur = pdo.getPers(var1); // Implement this method
		if (existingProfesseur != null) {
			pdo.deleteProfesseur(var1);
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(String nom, String prenom, int age) {
		pdo.saveProfesseur(nom, age, prenom);
		return Response.status(Response.Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professeur getPerson(@PathParam("id") int var1) {
		Professeur Professeur = pdo.getPers(var1);
		return Professeur;
	}

}
