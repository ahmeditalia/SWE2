package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
@Entity(name = "OnlineStore")

public class OnlineStore extends Store {

	public OnlineStore(StoreIdentity storeName) {
		super(storeName);
	}
	public OnlineStore(){}
}
