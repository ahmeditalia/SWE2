package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public abstract class Stat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Integer id;
    protected String operation;
    protected String object;
    protected boolean added;
    
	public Stat() {
		super();
	}
	public Stat(boolean added) {
		super();
		this.added = added;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isAdded() {
		return added;
	}
	public void setAdded(boolean added) {
		this.added = added;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public abstract int visitme(Visitor visitor,String sname);
    
}
