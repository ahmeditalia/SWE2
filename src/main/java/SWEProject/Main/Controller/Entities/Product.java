package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.TABLE)
	protected Integer id;
	protected String name;
	@NotNull
	@ManyToOne
	@JoinColumn(name="brandId")
	protected Brand brand;
	@NotNull
	protected String type;
	public Product(){}

	
	public Product(String name, Brand brand, String type) {
		super();
		this.name = name;
		this.brand = brand;
		this.type = type;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
