package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public interface Product {

	public Integer getId();

	@NotNull
	public String getName();

	public void setName(String name);

	@NotNull
	public Brand getBrand();

	public void setBrand(Brand brand);

	@NotNull
	public String getType();

	public void setType(String type);

	@NotNull
	public Store getStore();

	public void setStore(Store store);

}
