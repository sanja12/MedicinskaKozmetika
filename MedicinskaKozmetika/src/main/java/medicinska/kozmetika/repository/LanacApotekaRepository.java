package medicinska.kozmetika.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.LanacApoteka;

@Repository
public interface LanacApotekaRepository extends JpaRepository<LanacApoteka, Long> {

	List<LanacApoteka> findByNaziv(String naziv);

}
