/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.EmployeeDTO;
import facades.EmployeeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.PathParam;
import static rest.RenameMeResource.emf;

/**
 * REST Web Service
 *
 * @author zzar
 */
@Path("employee")
public class EmployeeRest {

    EntityManagerFactory em = Persistence.createEntityManagerFactory("pu");
    EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(em);
    Gson g = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeRest
     */
    public EmployeeRest() {
    }

    /**
     * Retrieves representation of an instance of rest.EmployeeRest
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        List<Employee> list = facade.getAllEmployees();
        return g.toJson(list);
    }

    @GET
    @Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimalsById(@PathParam("id") int id) {
        Employee emp = facade.getEmployeeById(id);
        EmployeeDTO empD = new EmployeeDTO(emp);
        return g.toJson(empD);
    }
    
    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getByName(@PathParam("name") String name) {
        List emp = facade.getEmployeesByName(name);
        EmployeeDTO emp1 = new EmployeeDTO((Employee) emp.get(0));
        return g.toJson(emp1);
    }
    
}
