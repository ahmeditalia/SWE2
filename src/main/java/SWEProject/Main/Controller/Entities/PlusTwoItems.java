package SWEProject.Main.Controller.Entities;

public class PlusTwoItems extends Discount {
    public PlusTwoItems(Discount discount){
        super(discount);
        this.dis=10;
    }
    @Override
    public double getDis(){
        return  dis+discount.getDis();
    }

}
