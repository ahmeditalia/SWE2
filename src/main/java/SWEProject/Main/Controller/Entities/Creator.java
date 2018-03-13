package SWEProject.Main.Controller.Entities;

public class Creator {
	private static Creator instance=null;
	private Creator() {
	}
	public static Creator getInstance() {
		if(instance==null)
		{
			instance=new Creator();
		}
		return instance;
	}
	public User createUser(String type,User user)
	{
		if(type.equals("admin"))
		{
			return new Admin(user);
		}
		else if(type.equals("store owner"))
		{
			return new StoreOwner(user);
		}
		else if(type.equals("normal user"))
		{
			return null;
		}
		return null;
	}
	
	public Store createStore(String type,Store store)
	{
		if(type.equals("online store"))
		{
		}
		else if(type.equals("onsite store"))
		{
		}
		return null;
	}
}
  