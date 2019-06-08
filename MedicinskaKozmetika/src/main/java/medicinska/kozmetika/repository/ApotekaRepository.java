package medicinska.kozmetika.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import medicinska.kozmetika.model.Apoteka;

@Repository
public interface ApotekaRepository extends JpaRepository<Apoteka, Long> {

	List<Apoteka> findByLanacApotekaId(Long lanacApotekaId);
	
	@Query("SELECT a FROM Apoteka a WHERE "
			+ "(:naziv IS NULL or a.naziv like :naziv ) AND "
			+ "(:grad IS NULL OR a.grad like :grad)"
		   )
	List<Apoteka> pretragaPoNazivuIliGradu(
			@Param("naziv") String naziv, 
			@Param("grad") String grad);


}
