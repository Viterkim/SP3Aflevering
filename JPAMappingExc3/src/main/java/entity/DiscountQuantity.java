
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class DiscountQuantity extends DiscountType implements Serializable
{

    private static final long serialVersionUID = 1L;
    int quantityForDiscount = 3;
    double discount = 0.2; //20% discount if 3 or more
    @Override
    public double calcDiscount(double priceItem, int quantity)
    {
        return (discount >= quantityForDiscount) ? (priceItem * quantity * discount) : (0);
    }
    
}
