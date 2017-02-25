
package data;

import entity.Student;
import entity.Studypoint;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


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
            //Test methods
            
            System.out.println
            (
                "" + facade.totalStudyPointsAll()
            );
            
            facade.em.getTransaction().commit(); //Commits the transaction
        }
        finally
        {
            facade.em.close();
        }
    }
    
    public Student addStudent(Student s)
    {
        em.persist(s);
        return s;
    }
    
    public Studypoint addStudyPoint(Studypoint sp)
    {
        em.persist(sp);
        return sp;
    }
    
    public List<Student> getAllStudents()
    {
        List<Student> students;
        Query query = em.createQuery("SELECT s FROM Student as s");
        students = query.getResultList();
        return students;
    }
    
    public List<Student> getStudentsNameJan()
    {
        List<Student> students;
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.firstname = 'jan'");
        students = query.getResultList();
        return students;
    }
    
    public List<Student> getStudentsLastNameOlsen()
    {
        List<Student> students;
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.lastname = 'Olsen'");
        students = query.getResultList();
        return students;
    }
    
    public int totalStudyPointsSpecific(int id) // Problem
    {
        Query query = em.createQuery("SELECT SUM(st.score) FROM studypoint st where st.student_id = :id");
        //SELECT s.id FROM Student s WHERE s.id = :id)
        int total = (int)query.getSingleResult();
        return total;
    }
    
    public int totalStudyPointsAll() // Problem
    {
        Query query = em.createQuery("SELECT SUM(st.SCORE) FROM studypoint st");
        //SELECT s.id FROM Student s WHERE s.id = :id)
        int total = (int)query.getSingleResult();
        return total;
    }
}
