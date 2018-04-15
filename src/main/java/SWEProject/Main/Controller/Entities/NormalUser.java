package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class NormalUser extends User{
    public NormalUser() {
    	super();
    }
    public NormalUser(User user)
    {
    	super(user.username, user.password, user.email);
    }

}
