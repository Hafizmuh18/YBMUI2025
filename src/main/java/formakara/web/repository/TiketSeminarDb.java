package formakara.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formakara.web.models.TiketSeminar;

@Repository
public interface TiketSeminarDb extends JpaRepository<TiketSeminar, Integer> {
    
}
