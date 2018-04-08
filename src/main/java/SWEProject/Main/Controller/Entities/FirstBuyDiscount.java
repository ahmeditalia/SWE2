package SWEProject.Main.Controller.Entities;

public class FirstBuyDiscount extends Discount {
    public FirstBuyDiscount(Discount discount){
        this.discount=discount;
        this.dis=5;
    }
    @Override
    public double getDis(){
        return  dis+discount.getDis();
    }
}
