package medicinska.kozmetika.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.model.TipPromocije;

@Repository
public interface PromocijaRepository extends JpaRepository<Promocija, Long> {
	
	@Query("SELECT p FROM Promocija p WHERE "
			+ "(:datum IS NULL or p.datum <= :datum ) AND "
			+ "(:tip IS NULL OR p.tipPromocije = :tip) AND "
			+ "(:vrijeme IS NULL or p.vrijeme <= :vrijeme ) AND "
			+ "(:apoteka IS NULL OR p.apoteka.id = :apoteka) AND "
			+ "(:naziv IS NULL OR p.apoteka.naziv = :naziv) AND "
			+ "(:grad IS NULL OR p.apoteka.grad = :grad) AND "
			+ "(:lanac IS NULL OR p.apoteka.lanacApoteka.id = :lanac) "

		   )
	Page<Promocija> search(
			@Param("datum") LocalDate datum, 
			@Param("tip") TipPromocije tip,
			@Param("vrijeme") LocalTime vrijeme,
			@Param("apoteka") Long apoteka,
			@Param("naziv") String naziv, 
			@Param("grad") String grad,
			@Param("lanac") Long lanac,
			Pageable pageRequest
			);

}
