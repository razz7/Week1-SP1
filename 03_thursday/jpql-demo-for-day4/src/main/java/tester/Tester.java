package tester;

import entity.Employee;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Employee("xa12tt", "Kurt", "Wonnegut", new BigDecimal(335567)));
            em.persist(new Employee("hyu654", "Hanne", "Olsen", new BigDecimal(435867)));
            em.persist(new Employee("uio876", "Jan", "Olsen", new BigDecimal(411567)));
            em.persist(new Employee("klo999", "Irene", "Petersen", new BigDecimal(33567)));
            em.persist(new Employee("jik666", "Tian", "Wonnegut", new BigDecimal(56567)));
            em.getTransaction().commit();

            //Complete all these small tasks. Your will find the solution to all, but the last,
            //In this document: https://en.wikibooks.org/wiki/Java_Persistence/JPQL#JPQL_supported_functions
            //1) Create a query to fetch all employees with a salary > 100000 and print out all the salaries
            TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e WHERE e.salary >= 100000", Employee.class);
            List a = query.getResultList();
            System.out.println("salary > 1000000 " + a);

            //2) Create a query to fetch the employee with the id "klo999" and print out the firstname
            TypedQuery<Employee> query1 = em.createQuery("SELECT e FROM Employee e WHERE e.id = \"klo999\"", Employee.class);
            List b = query1.getResultList();
            System.out.println("id == klo999" + b);

            //3) Create a query to fetch the highest salary and print the value
            TypedQuery<Employee> query2 = em.createQuery("SELECT e FROM Employee e", Employee.class);
            List c = query2.getResultList();
            
            System.out.println("id == klo999" + c);
            //4) Create a query to fetch the firstName of all Employees and print the names
            //5 Create a query to calculate the number of employees and print the number
            //6 Create a query to fetch the Employee with the higest salary and print all his details
        } finally {
            em.close();
            emf.close();
        }
    }

}
