package SWEProject.Main.Controller.Repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import SWEProject.Main.Controller.Entities.Transactions;
@Transactional
public interface TransactionRepository extends CrudRepository<Transactions,Integer>{
/*
	@Query("select count(Buyer) where store =:storeName")
	int sumOfUsers(@Param("storeName")Store store);
	*/
}
