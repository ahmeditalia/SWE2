package SWEProject.Main.Controller.Entities;

import org.hibernate.loader.custom.Return;

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
	
	public Store createStore(String type,Store store,StoreOwner storeOwner)
	{
		if(type.equals("onlineStore"))
		{
			return new OnlineStore(store.getStoreName(), storeOwner, store.getLocation(), store.getType());
		}
		else if(type.equals("onsiteStore"))
		{
			return new OnsiteStore(store.getStoreName(), storeOwner, store.getLocation(), store.getType());
		}
		return null;
	}
}  