package medicinska.kozmetika.service;

import java.util.List;
import org.springframework.data.repository.query.Param;
import medicinska.kozmetika.model.Apoteka;

public interface ApotekaService {

	List<Apoteka> findAll();

	Apoteka findOne(Long id);

	Apoteka save(Apoteka apoteka);

	Apoteka delete(Long id);

	List<Apoteka> findByLanacApotekaId(Long lanacApotekaId);
	
	List<Apoteka> pretragaPoNazivuIliGradu(
			@Param("naziv") String naziv, 
			@Param("grad") String grad);

}
