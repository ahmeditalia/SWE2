package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.Statistics;
import SWEProject.Main.Controller.Repository.AllStatisticsRepository;
import SWEProject.Main.Controller.Repository.StatisticsRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Controller
public class AllStatisticsController {
    @Autowired
    AllStatisticsRepository allStatisticsRepo;
    @Autowired
    StatisticsRepository statRepo;
    @Autowired
    StoreRepository storeRepo;
    
    @RequestMapping("/addstatistics")
    @ResponseBody
    public void addstatistics(@RequestBody String operation,@RequestBody String entity){
     //   AllStatistics a=allStatisticsRepo.findByOperationAndEntity(operation,entity);
       // allStatisticsRepo.updateAdded(a.getId());
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
}