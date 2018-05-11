package SWEProject.Main.Controller.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import SWEProject.Main.Controller.Repository.StoreRepository;
import SWEProject.Main.Controller.Repository.TransactionRepository;

@Controller
public class VisitorSum implements Visitor{
	@Autowired
	TransactionRepository transRepo;
	@Autowired
	StoreRepository storeRepo;
	@Override
	public int visit(UsersStat visited,String sname) {
		/*return transRepo.sumOfUsers(storeRepo.findOne(sname));*/
		return 100;
	}

}
