/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author zzar
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer Customer = em.find(Customer.class, id);
            return Customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer WHERE customer.name =" + name, Customer.class).setParameter(1, name);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public int getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList().size();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("pu");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(em);
        Customer cus1 = cf.addCustomer("Harry", "Potter");
        Customer cus2 = cf.addCustomer("John", "Snow");
        //Find book by ID
        System.out.println("Customer1: " + cf.findCustomerByID(cus1.getId()));
        System.out.println("Customer2: " + cf.findCustomerByID(cus2.getId()));
        //Find all books
        System.out.println("Number of Customers: " + cf.allCustomers());
        //Customer by last name
        System.out.println("Customer2: " + cf.findByLastName("Potter"));
        //Number of all customers
        System.out.println("Number of all customers: " + cf.getNumberOfCustomers());
    }

}
