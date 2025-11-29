package polyglot.ms.test.pay.repository;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import polyglot.ms.test.pay.model.PayModel;
 
@Repository
public interface IPayRepository extends CrudRepository<PayModel, Long>{
   
}

