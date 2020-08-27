/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfacade;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author zzar
 */
public class BookFacade {
     private static EntityManagerFactory emf;
    private static BookFacade instance;

    private BookFacade() {}

    public static BookFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookFacade();
        }
        return instance;
    }
    
    /**
     *
     * @param author
     * @returns book 
     * takes an author and creates book obj to write to db with a transaction
     * created by the entitymanager. 
     */
    public Book addBook(String author){
        Book book = new Book(author);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            return book;
        }finally {
            em.close();
        }
    }
    
    /**
     *
     * @param id
     * @returns book 
     * takes id and returns the book from db since we are not writing to the sb
     * we dont need to create an transaction.
     */
    public Book findBook(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Book book = em.find(Book.class,id);
            return book;
        }finally {
            em.close();
        }
    }
    
    /**
     *
     * @returns a list of books
     * we use typedQuery to send to the db and take all the results and retuns 
     * a list
     */
    public List<Book> getAllBooks(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Book> query = 
                       em.createQuery("Select book from Book book",Book.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    
    
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    BookFacade facade = BookFacade.getBookFacade(emf);
    Book b1 = facade.addBook("Author 1");
    Book b2 = facade.addBook("Author 2");
    //Find book by ID
    System.out.println("Book1: "+facade.findBook(b1.getId()).getAuthor());
    System.out.println("Book2: "+facade.findBook(b2.getId()).getAuthor());
    //Find all books
    System.out.println("Number of books: "+facade.getAllBooks().size());

    }

}
