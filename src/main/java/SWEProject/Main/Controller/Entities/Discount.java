package SWEProject.Main.Controller.Entities;

import javax.persistence.*;
@Entity
@Inheritance
public abstract class Discount {
    @Id    
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;
    protected double dis;
    public Discount(double dis) {
		super();
		this.dis = dis;
	}
	public Discount() {
        dis=0;
    }
    public abstract  double getDis();
    public abstract Discount deleteDiscount(Class c);
    public abstract Integer find(Class c);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDis(double dis) {
		this.dis = dis;
	}

}
