
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
public class Employee extends Person implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private int soSecNr;
    private float wage;
    private String taxClass;

    public Employee(int soSecNr, float wage, String taxClass, String firstName, String lastName, String birthDate, int age, boolean isMarried)
    {
        super(firstName, lastName, birthDate, age, isMarried);
        this.soSecNr = soSecNr;
        this.wage = wage;
        this.taxClass = taxClass;
    }

    public Employee()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setSoSecNr(int soSecNr)
    {
        this.soSecNr = soSecNr;
    }

    public void setWage(float wage)
    {
        this.wage = wage;
    }

    public void setTaxClass(String taxClass)
    {
        this.taxClass = taxClass;
    }

    
   
}
