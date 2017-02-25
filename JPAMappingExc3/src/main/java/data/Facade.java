
package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Facade
{
    
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin(); // Begin set of instructions
            
            
            
            em.getTransaction().commit(); //Commits the transaction
        }
        finally
        {
            em.close();
        }
    }
}
