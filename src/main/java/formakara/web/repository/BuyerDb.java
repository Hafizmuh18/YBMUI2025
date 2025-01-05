package formakara.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formakara.web.models.Buyer;

@Repository
public interface BuyerDb extends JpaRepository<Buyer, Integer>{
    
}
