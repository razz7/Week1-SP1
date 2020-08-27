/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Animal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author zzar
 */
@Path("animals_db")
public class AnimalsFromDB {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalsFromDB
     */
    public AnimalsFromDB() {
    }

    @Path("animalsdb")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimals() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a", Animal.class);
            List<Animal> animals = query.getResultList();
            System.out.println(animals);
            return new Gson().toJson(animals);
        } finally {
            em.close();
        }
    }
    
    
    @Path("animalsbyid/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalsById(@PathParam("id") int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a where a.id =" + id, Animal.class);
            List<Animal> animals = query.getResultList();
            System.out.println(animals);
            return new Gson().toJson(animals);
        } finally {
            em.close();
        }
    }
    
    //virker ikke 
    @Path("animalstype/{type}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalsById(@PathParam("type") String type) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Animal> query = em.createQuery("SELECT a FROM Animal a where a.type =" + type , Animal.class);
            List<Animal> animals = query.getResultList();
            System.out.println(animals);
            return new Gson().toJson(animals);
        } finally {
            em.close();
        }
    }

    /**
     * Retrieves representation of an instance of rest.AnimalsFromDB
     *
     * @return an instance of java.lang.String
     */
}
