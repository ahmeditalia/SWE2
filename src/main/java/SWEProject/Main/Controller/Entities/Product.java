package SWEProject.Main.Controller.Entities;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public abstract class Product {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	protected Integer id;
	protected String name;
	@NotNull
	@ManyToOne
	@JoinColumn(name="brandId")
    @JsonManagedReference
	protected Brand brand;
	@NotNull
	protected String type;

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
	public Product(){}
}
