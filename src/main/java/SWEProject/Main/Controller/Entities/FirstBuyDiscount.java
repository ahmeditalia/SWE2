package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class FirstBuyDiscount extends IDiscount {
	public FirstBuyDiscount(Discount discount) {
		super(5.0);
		this.discount = discount;
	}
	public FirstBuyDiscount() {
		super(5.0);
	}
//	@Override
//	public void deleteDiscount(Class c) {
//		if(!(c.isInstance(this.getDiscount()))) {
//			this.discount=this.getDiscount().ge;
//		}
//		if(!(rDiscount.getDiscount() instanceof NoDiscount)) {
//			rDiscount.setDiscount(rDiscount.getDiscount().getDiscount());
//		}
//		
//	}
}
