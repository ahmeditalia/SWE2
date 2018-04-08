package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class NormalUser extends User{
    public NormalUser() {
        balance = 0;
    }
    public NormalUser(User user)
    {
        this.username=user.username;
        this.password=user.password;
        this.email=user.email;
    }

}
