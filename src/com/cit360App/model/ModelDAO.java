package com.cit360App.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;

//implemented using singleton pattern
//Used to get customer data from mysql database
public class ModelDAO {
    SessionFactory factory = null;
    Session session = null;

    private static ModelDAO single_instance = null;

    private ModelDAO()
    {
        factory = HibernateUtilities.getSessionFactory();
    }

    /** This makes the class a singleton.
     *  This is used to get an instance of the class. */
    public static ModelDAO getInstance()
    {
        if (single_instance == null) {
            single_instance = new ModelDAO();
        }

        return single_instance;
    }

    /** Used to get more than one customer from database
     *  Using the OpenSession construct
     *  The Session has to be closed in finally block.*/
    public List<Customer> getCustomers() {

        try {
            session = factory.openSession(); //open session
            session.getTransaction().begin(); //begin transaction
            String sql = "from com.cit360App.model.Customer";  //defines SQL
            List<Customer> cl = (List<Customer>)session.createQuery(sql).getResultList();  //create the query and get results
            session.getTransaction().commit();  //commit the transaction
            return cl;   //return list

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback back if error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();  //close session
        }

    }

    /** Used to get a single customer from database */
    public Customer getCustomer(int id) {

        try {
            session = factory.openSession();  //open session
            session.getTransaction().begin();  //begin transaction
            String sql = "from com.cit360App.model.Customer where id=" + Integer.toString(id);  //define sql with where clause
            Customer c = (Customer)session.createQuery(sql).getSingleResult(); //create the query and get the results.
            session.getTransaction().commit(); //commit transaction
            return c;  //return list

        } catch (Exception e) {
            e.printStackTrace();
            // Roll back if error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

}
