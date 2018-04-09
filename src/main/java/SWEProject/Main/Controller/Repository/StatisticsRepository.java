package SWEProject.Main.Controller.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import SWEProject.Main.Controller.Entities.Statistics;
import SWEProject.Main.Controller.Entities.Store;

import org.springframework.data.repository.query.Param;

public interface StatisticsRepository extends CrudRepository<Statistics, Integer>{
@Query("UPDATE Statistics s set s.numUserView=s.numUserView+1 where s.store=:store")
    void updateNumUserView(@Param("store") String store);
@Query("UPDATE Statistics s set s.numUserBuy=s.numUserBuy+1 where s.store=:store")
    void updateNumUserBuy(@Param("store") String store);
@Query("UPDATE Statistics s set s.soldProducts=s.soldProducts+:soldPro where s.store=:store")
    void updateSoldProducts(@Param("store") String store,@Param("soldPro")int soldPro);
	
	Statistics findOneByStore_StoreName(String storeName);

}
