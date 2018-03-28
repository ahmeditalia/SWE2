package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class NormalUser extends User{
    double Balance;

    public NormalUser() {
        Balance = 0;
    }
    public NormalUser(User user)
    {
        this.username=user.username;
        this.password=user.password;
        this.email=user.email;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
