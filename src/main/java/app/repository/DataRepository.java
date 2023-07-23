package app.repository;

import app.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DataRepository extends JpaRepository<Request, Integer> {

    Optional<Request> findFirstByKey(Integer key);

    @Query(nativeQuery = true, value = "" +
            "SELECT COUNT(id) FROM request ")
    long countRequests();
}
