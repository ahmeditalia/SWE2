package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@MappedSuperclass
public interface Product {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Integer getId();

	@NotNull
	public String getName();

	public void setName(String name);

	@ManyToOne
	@JoinColumn(name ="id")
	public ProductStore getProductStore();

	@ManyToOne
	@JoinColumn(name ="id")
	public Brand getBrand();

	public void setBrand(Brand brand);

	@NotNull
	public String getType();

	public void setType(String type);

}
