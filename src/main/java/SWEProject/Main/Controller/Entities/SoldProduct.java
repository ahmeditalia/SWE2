package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
@Entity
public class SoldProduct extends Product{
    @NotNull
    private int quantity;
    @NotNull
    private double price;
    @NotNull
    private double priceAD;
    public SoldProduct() {
		super();
		this.quantity = 0;
		this.price = 0;
	}
    
	public SoldProduct(int quantity, double price, double priceAD) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.priceAD = priceAD;
	}

	public SoldProduct(Product product,int quantity, double price,double priceAD) {
		super(product.name, product.brand, product.type);
		this.quantity = quantity;
		this.price = price;
		this.priceAD=priceAD;
	}
	public SoldProduct(StoreProduct product ,double priceAD) {
		super(product.name, product.brand, product.type);
		this.quantity = product.getQuantity();
		this.price = product.getPrice();
		this.priceAD=priceAD;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPriceAD() {
		return priceAD;
	}
	public void setPriceAD(double priceAD) {
		this.priceAD = priceAD;
	}
    
}
