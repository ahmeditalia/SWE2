package SWEProject.Main.Controller.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Transactions {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private User Buyer;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Store store;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private SoldProduct SoldItem;
	public Transactions(User buyer, Store store, SoldProduct soldItem) {
		super();
		Buyer = buyer;
		this.store = store;
		SoldItem = soldItem;
	}
	public User getBuyer() {
		return Buyer;
	}
	public void setBuyer(User buyer) {
		Buyer = buyer;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public SoldProduct getSoldItem() {
		return SoldItem;
	}
	public void setSoldItem(SoldProduct soldItem) {
		SoldItem = soldItem;
	}
}
