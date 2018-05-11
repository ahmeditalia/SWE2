package SWEProject.Main.Controller.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance
public abstract class IDiscount extends Discount {

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    protected Discount discount;
	public IDiscount() {
	}
	public IDiscount( double dis) {
		this.dis=dis;
	}
	public void setDiscount(Discount discount) {
		this.discount=discount;
	}
	public Discount getDiscount() {
		return discount;
	}
	@Override
	public double getDis() {
		return dis+discount.getDis();
	}
	@Override
	public Discount deleteDiscount(Class c) {
		if(c.isInstance(this))
		{
			return this.discount;
		}
		discount=discount.deleteDiscount(c);
		return this;
	}
	@Override
	public Integer find(Class c) {
		if(c.isInstance(this))
		{
			return this.id;
		}
		return discount.find(c);
	}
	@PreRemove
	private void removeEducationFromUsersProfile() {
		discount=null;
	}
}