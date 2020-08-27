/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest1;

import entity.Animal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author zzar
 */
public class Main {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Animal a = new Animal("Duck", "quack");
        Animal b = new Animal("Dog", "Vof");
        em.getTransaction().begin();
        em.persist(a);
        em.persist(b);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }
}
