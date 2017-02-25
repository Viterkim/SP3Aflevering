
package data;

import entity.Employee;
import entity.Grade;
import entity.Person;
import entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Facade
{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
    private EntityManager em = emf.createEntityManager();

    public static void main(String[] args)
    {
        Facade facade = new Facade();
        try
        {
            facade.em.getTransaction().begin(); // Begin set of instructions
            
            Person p = new Person("Viktor", "Bingomanden", "26/7/95", 85, false);
            Grade g = new Grade("Math", 12);
            facade.addGrade(g);
            p.setGrade(g);
            facade.addPerson(p);
            p.setFirstName("Bingo");
            facade.addPerson(p);
            
            
            facade.em.getTransaction().commit(); //Commits the transaction
        }
        finally
        {
            facade.em.close();
        }
    }
    
    
    public void addPerson(Person p)
    {
        em.persist(p);
    }
    
    public void addEmployee(Employee e)
    {
        em.persist(e);
    }
    
    public void addStudent(Student s)
    {
        em.persist(s);
    }
    
    public void addGrade(Grade g)
    {
        em.persist(g);
    }
    
    public void deletePerson(Person p)
    {
        em.remove(p);
    }
    
    public void deleteGrade(Grade g)
    {
        em.remove(g);
    }
    
}
