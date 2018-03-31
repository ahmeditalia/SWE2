package SWEProject.Main.Controller;

import SWEProject.Main.Controller.Entities.AllStatistics;
import SWEProject.Main.Controller.Entities.Store;
import SWEProject.Main.Controller.Entities.StoreProduct;
import SWEProject.Main.Controller.Repository.AllStatisticsRepository;
import SWEProject.Main.Controller.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AllStatisticsController {
    @Autowired
    AllStatisticsRepository allStatisticsRepo;

    @RequestMapping("/addstatistics")
    @ResponseBody
    public void addstatistics(@RequestBody String operation,@RequestBody String entity){
        AllStatistics a=allStatisticsRepo.findByOperationAndEntity(operation,entity);
        allStatisticsRepo.updateAdded(a.getId());
    }
}
