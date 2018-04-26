package SWEProject.Main.Controller.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    protected Discount discount;
    protected double dis;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    protected User user;
    protected String type;
    public Discount() {
        type="Discount";
        dis=0;
    }
    public Discount getDiscount() {return discount;}
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    public  double getDis() {
        if(type.equals("NoDiscount"))
            return 0;
        return dis+discount.getDis();
    }
    public void x(){System.out.println("x");}
    public void setDis(double d) {
        this.dis = d;
    }
    public void addDiscount(String c){
        Discount r=this;
        while (!(r.getDiscount().type.equals("NoDiscount") )){
            r=r.getDiscount();
        }
        if(c.equals("StoreOwnerDiscount")) {
            StoreOwnerDiscount s = new StoreOwnerDiscount();
            s.setDiscount(r.getDiscount());
            r.setDiscount(s);
        }
    }
    public void deleteDiscount(String c){
        Discount r=this;
        while (!(c.equals(r.getDiscount().type))&&!(r.getDiscount().type.equals("NoDiscount"))){
            r=r.getDiscount();
        }
        if(!(r.getDiscount().type.equals("NoDiscount")))
        {
            r.setType(r.getDiscount().getDiscount().getType());
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
