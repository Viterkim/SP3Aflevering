
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String firstName;
    private String lastName;
    private String birthDate;
    private int age;
    private boolean isMarried;
    
    @OneToOne
    private Grade grade;
    
    @OneToOne
    private Person supervisor;
    
    @OneToOne
    private Person supervised;

    public Person(String firstName, String lastName, String birthDate, int age, boolean isMarried)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.isMarried = isMarried;
    }

    public Person()
    {
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getBirthDate()
    {
        return birthDate;
    }

    public int getAge()
    {
        return age;
    }

    public boolean isIsMarried()
    {
        return isMarried;
    }
    
    public Integer getId()
    {
        return id;
    }

    public Grade getGrade()
    {
        return grade;
    }

    public void setGrade(Grade grade)
    {
        this.grade = grade;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public Person getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(Person supervisor)
    {
        this.supervisor = supervisor;
    }

    public Person getSupervised()
    {
        return supervised;
    }

    public void setSupervised(Person supervised)
    {
        this.supervised = supervised;
    }

    
    
}
