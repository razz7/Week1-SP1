/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author zzar
 */
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String Address;
    private int Salary;

    public Integer getId() {
        return id;
    }

    public Employee(String Name, String Address, int Salary) {
        this.Name = Name;
        this.Address = Address;
        this.Salary = Salary;
    }

    public Employee() {
    }
    


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    
    

    
    
}
