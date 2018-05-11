package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;

@Entity
public class UsersStat extends Stat{

	@Override
	public int visitme(Visitor visitor,String sname) {
		return visitor.visit(this,sname);
	}
	
}
