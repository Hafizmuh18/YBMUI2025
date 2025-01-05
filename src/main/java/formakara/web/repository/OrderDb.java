package formakara.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formakara.web.models.Order;

@Repository
public interface OrderDb extends JpaRepository <Order, Integer>{
    
}
