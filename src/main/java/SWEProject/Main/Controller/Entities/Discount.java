package SWEProject.Main.Controller.Entities;

public  class Discount {
    protected   Discount discount;
    protected   double dis;
    public Discount(){dis=0;}
    public Discount(Discount discount){
        this.discount=discount;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getDis() {
        return dis;
    }

    public void setDis(double d) {
        this.dis = d;
    }
}
