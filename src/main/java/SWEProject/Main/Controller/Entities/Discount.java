package SWEProject.Main.Controller.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Entity
public  class Discount {
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
    public Discount(){
        dis=0;
    }
    public Discount(User user){
        dis=0;
        this.user=user;
        FirstBuyDiscount f = new FirstBuyDiscount();
        this.setDiscount(f);
        NoDiscount ff=new NoDiscount();
        f.setDiscount(ff);
    }
    public Discount getDiscount() {return discount;}
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    public double getDis() {
        return dis+discount.getDis();
    }
    public void setDis(double d) {
        this.dis = d;
    }
    public void addDiscount(Class c){
        Discount r=this;
        while (!(r.getDiscount()instanceof NoDiscount)){
            r=r.getDiscount();
        }
        try {
            Method[] methods = c.getMethods();
            Object obj=c.newInstance();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().startsWith("setDiscount")) {
                    methods[i].invoke(obj,r.getDiscount());
                }
            }
            r.setDiscount((Discount) obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    public void deleteDiscount(Class c){
        Discount r=this;
        while (!(c.isInstance(r.getDiscount()))&&!(r.getDiscount()instanceof NoDiscount)){
            r=r.getDiscount();
        }
        if(!(r.getDiscount()instanceof NoDiscount))
        {
            r.setDiscount(r.getDiscount().getDiscount());
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
