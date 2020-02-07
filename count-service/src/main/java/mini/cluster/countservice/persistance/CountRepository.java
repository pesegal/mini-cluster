package mini.cluster.countservice.persistance;

import org.springframework.data.repository.CrudRepository;

public interface CountRepository extends CrudRepository<CountValue, Integer> {
}
