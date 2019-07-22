package medicinska.kozmetika.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.Proizvod;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {
	
	@Query("SELECT p FROM Proizvod p WHERE "
			+ "(:id IS NULL or p.linijaKozmetike.id = :id ) "
		  )
	Page<Proizvod> search(
			@Param("id") Long id, 
			Pageable pageRequest
			);

}
