package fox.bouron.Bourbon.bourbon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BourbonRepository extends CrudRepository<Bourbon, Integer> {
    List<Bourbon> findBourbonByDistiller(String distiller);
    Optional<Bourbon> findBourbonByName(String name);
    List<Bourbon> findBourbonByAbvBetween(double lowArg, double highArg);
    List<Bourbon> findBourbonByYear(int year);
    List<Bourbon> findBourbonByAged(int aged);


}
