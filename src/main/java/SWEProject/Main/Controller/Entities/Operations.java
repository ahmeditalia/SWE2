package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

public interface Operations {
public void increamentUserViews();
    public void increamentUserBuy();
    public void increamentSoldProducts(int numProducts);
}
