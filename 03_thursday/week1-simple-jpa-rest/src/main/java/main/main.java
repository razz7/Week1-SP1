/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Employee;

/**
 *
 * @author zzar
 */
public class main {

    public static void main(String[] args) {
        
        Employee e1 = new Employee("James", "Nørrebrogade 1", 10);
        Employee e2 = new Employee("Peter", "Østerbrogade 2", 242);
        Employee e333 = new Employee("Bond", "Vesterbrogade 3", 454);
        Employee e4 = new Employee("Ricky", "Frb alle 1", 23);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(e1);
        em.persist(e2);
        em.persist(e333);
        em.persist(e4);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
