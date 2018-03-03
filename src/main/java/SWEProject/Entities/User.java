package SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance
public abstract class User {
	@Id
	private String username;
	@NotNull
	private String email;
	@NotNull
	private String Password;

	public User() {
		super();
		username="";
		email="";
		Password="";
	}
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		Password = password;
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
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
