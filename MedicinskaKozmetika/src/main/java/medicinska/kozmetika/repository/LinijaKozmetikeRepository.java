package medicinska.kozmetika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.LinijaKozmetike;

@Repository
public interface LinijaKozmetikeRepository extends JpaRepository<LinijaKozmetike, Long> {
	
	List<LinijaKozmetike> findByNaziv(String naziv);

}
