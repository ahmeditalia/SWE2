package SWEProject.Main.Controller;
import SWEProject.Main.Controller.Entities.Statistics;
import SWEProject.Main.Controller.Repository.AllStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Controller
public class AllStatisticsController {
    @Autowired
    AllStatisticsRepository allStatisticsRepo;
    @RequestMapping("/addstatistics")
    @ResponseBody
    public void addstatistics(@RequestBody String operation,@RequestBody String entity){
     //   AllStatistics a=allStatisticsRepo.findByOperationAndEntity(operation,entity);
       // allStatisticsRepo.updateAdded(a.getId());
    }
    @RequestMapping("/statistics")
    @ResponseBody
    public Statistics showstat(@RequestBody String sname) {
        //return statrepo.findOne(sname);
        // example
        Random rand = new Random();
        int n = rand.nextInt(250);
        int m = rand.nextInt(n);
        Statistics statistics = new Statistics(n, m, rand.nextInt(m));
        return statistics;
    }
}