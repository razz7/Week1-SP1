/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mode1.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author zzar
 */
@Path("animals")
public class AnimalDemo {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalDemo
     */
    public AnimalDemo() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalDemo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/1")
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "vuuf..(from af dog)";
    }

    /**
     * PUT method for updating or creating an instance of AnimalDemo
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Path("/animal_list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalList() {
        return "\"[Dog, Cat, Mouse, Bird]\"";
    }

    @GET
    @Path("/animal") 
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalNoDB() {
        AnimalNoDB a = new AnimalNoDB("Duck", "Quack");
        String b = gson.toJson(a);
        return b;
    }

    

}
