package SWEProject.Main.Controller.Entities;

public class StoreOwnerDiscount extends Discount {
    public StoreOwnerDiscount(Discount discount){
        super(discount);
        this.dis=15;
    }
    @Override
    public double getDis(){
        return  dis+discount.getDis();
    }

}
