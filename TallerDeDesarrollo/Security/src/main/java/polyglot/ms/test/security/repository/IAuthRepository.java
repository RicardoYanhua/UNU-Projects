package polyglot.ms.test.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import polyglot.ms.test.security.model.AccessModel;
 
@Repository
public interface IAuthRepository extends CrudRepository<AccessModel, Long> {
   
}



