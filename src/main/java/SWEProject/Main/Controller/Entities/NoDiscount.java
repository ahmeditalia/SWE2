package SWEProject.Main.Controller.Entities;

public class NoDiscount extends Discount {
    public NoDiscount(){this.dis=0;}
    @Override
    public double getDis(){return 0;}
}
