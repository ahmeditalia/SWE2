package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class PlusTwoItems extends IDiscount {
	public PlusTwoItems(Discount discount) {
		super(10.0);
		this.discount = discount;
	}
	public PlusTwoItems() {
		super(10.0);
	}
}
