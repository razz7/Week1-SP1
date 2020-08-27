/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Employee;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author zzar
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;
    

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee emp = em.find(Employee.class, id);
            return emp;

        } finally {
            em.close();
        }
    }

    //virker ikke
    public List<Employee> getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = 
                    em.createQuery("SELECT e FROM Employee e WHERE e.name" , Employee.class);
            return query.getResultList();
            
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query = 
                    em.createQuery("Select employee from Employee employee", 
                            Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
