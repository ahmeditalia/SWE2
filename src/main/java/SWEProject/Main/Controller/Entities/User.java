package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

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
	protected boolean firstBuy;
	public User() {
		username="";
		email="";
		password="";
		balance=0;
	}


	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
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
	public boolean isFirstBuy() {
		return firstBuy;
	}
	public void setFirstBuy(boolean firstBuy) {
		this.firstBuy = firstBuy;
	}
}