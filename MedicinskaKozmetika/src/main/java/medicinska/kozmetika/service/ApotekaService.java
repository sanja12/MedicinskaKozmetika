package medicinska.kozmetika.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import medicinska.kozmetika.model.Apoteka;

public interface ApotekaService {
	
	Page<Apoteka> search(
			@Param("naziv") String naziv, 
			@Param("grad") String grad,
			@Param("lanac") Long lanac,
			int pageNum
			);
	Page<Apoteka> findAll(int pageNum);

	Apoteka findOne(Long id);

	Apoteka save(Apoteka apoteka);

	Apoteka delete(Long id);
	
}
