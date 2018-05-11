package SWEProject.Main.Controller.Repository;

import SWEProject.Main.Controller.Entities.Stat;
import SWEProject.Main.Controller.Entities.Brand;
import SWEProject.Main.Controller.Entities.StoreProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface  AllStatisticsRepository extends CrudRepository<Stat,Integer> {
   /* @Query("update AllStatistics a set a.added =1 where a.ID=:id")
    void updateAdded(@Param("id") int id);
    AllStatistics findByOperationAndEntity(String operation, String entity);*/
}
