package medicinska.kozmetika.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.LanacApoteka;

@Repository
public interface LanacApotekaRepository extends JpaRepository<LanacApoteka, Long> {

	@Query("SELECT la FROM LanacApoteka la WHERE "
			+ "(:naziv IS NULL OR la.naziv like :naziv ) "
			)
	Page<LanacApoteka> search(
			@Param("naziv") String naziv, 
			Pageable pageRequest);

}
