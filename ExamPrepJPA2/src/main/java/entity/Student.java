
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
public class Student extends Person implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int matNr;
    private String matDate;

    public Student(Integer id, int matNr, String matDate, String firstName, String lastName, String birthDate, int age, boolean isMarried)
    {
        super(firstName, lastName, birthDate, age, isMarried);
        this.id = id;
        this.matNr = matNr;
        this.matDate = matDate;
    }

    public Student()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public int getMatNr()
    {
        return matNr;
    }

    public String getMatDate()
    {
        return matDate;
    }

    public void setMatNr(int matNr)
    {
        this.matNr = matNr;
    }

    public void setMatDate(String matDate)
    {
        this.matDate = matDate;
    }

    
}
