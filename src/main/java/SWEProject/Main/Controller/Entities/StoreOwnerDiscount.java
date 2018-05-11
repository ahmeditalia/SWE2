package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class StoreOwnerDiscount extends IDiscount {
	public StoreOwnerDiscount(Discount discount) {
		super(15.0);
		this.discount = discount;
	}
	public StoreOwnerDiscount() {
		super(15.0);
	}
}
