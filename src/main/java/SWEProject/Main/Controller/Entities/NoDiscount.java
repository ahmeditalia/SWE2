package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
@Entity
public class NoDiscount extends Discount {
    public NoDiscount(){
    	this.dis=0;
    }
    @Override
    public double getDis() {return 0;}
	@Override
	public Discount deleteDiscount(Class c) {
		return this;
	}
	@Override
	public Integer find(Class c) {
		return -1;
	}

}
