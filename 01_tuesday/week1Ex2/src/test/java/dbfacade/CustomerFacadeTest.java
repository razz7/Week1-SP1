/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zzar
 */
public class CustomerFacadeTest {

    EntityManagerFactory em = Persistence.createEntityManagerFactory("pu");
    CustomerFacade cf = CustomerFacade.getCustomerFacade(em);

    public CustomerFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("pu");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(em);
        cf.addCustomer("junit", "Test");
    }

    /**
     * Test of getCustomerFacade method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testGetCustomerFacade() {
        System.out.println("getCustomerFacade");
        EntityManagerFactory emf = null;
        CustomerFacade result = CustomerFacade.getCustomerFacade(emf);
        assertTrue(result != null);
    }

    /**
     * Test of findCustomerByID method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindCustomerByID() {
        System.out.println("findCustomerByID");
        int id = 0;
        CustomerFacade instance = null;
        Customer expResult = null;
        Customer result = instance.findCustomerByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String name = "";
        CustomerFacade instance = null;
        List<Customer> expResult = null;
        List<Customer> result = instance.findByLastName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade instance = null;
        int expResult = 0;
        int result = instance.getNumberOfCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        String firstName = "";
        String lastName = "";
        CustomerFacade instance = null;
        Customer expResult = null;
        Customer result = instance.addCustomer(firstName, lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allCustomers method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testAllCustomers() {
        System.out.println("allCustomers");
        CustomerFacade instance = null;
        List<Customer> expResult = null;
        List<Customer> result = instance.allCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CustomerFacade.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CustomerFacade.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
