package formakara.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formakara.web.models.TiketTo;

@Repository
public interface TiketToDb extends JpaRepository<TiketTo, Integer> {
    
}
