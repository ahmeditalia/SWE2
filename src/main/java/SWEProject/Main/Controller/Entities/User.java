package SWEProject.Main.Controller.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Entity
@Inheritance
public class User {
	@Id
	protected String username;
	@NotNull
	protected String email;
	@NotNull
	protected String password;
	protected double balance;
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL)
	protected Discount discount;
	public User() {
		username="";
		email="";
		password="";
		balance=0;
		discount=new Discount(this);
	}


	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		discount=new Discount(this);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double b) {
		balance = b;
	}
	public void increaseBalance(double b){
		balance+=b;
	}
	public void decreaseBalance(double b){
		balance-=b;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
		discount.setUser(this);

	}
	public void deleteDiscount(Class c){
		discount.deleteDiscount(c);
	}
	public void addDiscount(Class c){
		discount.addDiscount(c);
	}
}