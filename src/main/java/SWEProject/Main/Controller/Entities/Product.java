package SWEProject.Main.Controller.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
	private String brand;
    private String category;
    private String type;
    
    
    
    public Product(Integer id, String name, String brand, String category, int quantity, String type) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.type = type;
	}



	public Product(){
        this.name="";
       this.brand ="";
        this.category ="";
        this.type ="";
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









	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
}
