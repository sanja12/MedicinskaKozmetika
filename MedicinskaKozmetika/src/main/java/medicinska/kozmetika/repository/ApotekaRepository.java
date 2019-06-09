package medicinska.kozmetika.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.Apoteka;

@Repository
public interface ApotekaRepository extends JpaRepository<Apoteka, Long> {

	@Query("SELECT a FROM Apoteka a WHERE "
			+ "(:naziv IS NULL or a.naziv like :naziv ) AND "
			+ "(:grad IS NULL OR a.grad like :grad) AND "
			+ "(:lanac IS NULL OR a.lanacApoteka.id = :lanac) "
		   )
	Page<Apoteka> search(
			@Param("naziv") String naziv, 
			@Param("grad") String grad,
			@Param("lanac") Long lanac,
			Pageable pageRequest
			);


}
