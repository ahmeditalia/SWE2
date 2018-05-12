package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.Statistics;
import SWEProject.Main.Controller.Repository.StatisticsRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
@Controller
public class StatisticsController {
    StatisticsRepository statRepo;
    StoreRepository storeRepo;
    
    @Autowired
    public StatisticsController(StatisticsRepository statRepo, StoreRepository storeRepo) {
		this.statRepo = statRepo;
		this.storeRepo = storeRepo;
	}


	@RequestMapping("/statistics")
    @ResponseBody
    public List<Statistics> showstat(@RequestBody List<String> Listsname) {
    	List<Statistics> retList=new ArrayList<Statistics>();
    	for(String sname:Listsname)
    	{
    		retList.add(statRepo.findOneByStore_StoreName(sname));
    	}
        return retList;
    }
    /*
    @RequestMapping("/addedStat")
    @ResponseBody
    public List<Integer[]> addedstat(@RequestBody List<String> Listsname) {
    	Iterable<Stat> stats=addedStateRepo.findAll();
    	List<Integer[]> ListStats=new ArrayList<Integer[]>();
    	Integer []temp = null;
    	for(String sname:Listsname)
    	{
    		for(Stat s:stats)
    		{
    			temp[0]=s.visitme(new VisitorSum(),sname);
    		}
    		ListStats.add(temp);
    	}
        return ListStats;
        
    }
*/
}