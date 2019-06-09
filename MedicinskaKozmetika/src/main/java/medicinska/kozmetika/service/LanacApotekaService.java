package medicinska.kozmetika.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import medicinska.kozmetika.model.LanacApoteka;;

public interface LanacApotekaService {
	
	Page<LanacApoteka> findAll(int pageNum);
	
	Page<LanacApoteka> search(
			@Param("naziv") String naziv, 
			int pageNum);

	LanacApoteka findOne(Long id);

	LanacApoteka save(LanacApoteka lanacApoteka);

	LanacApoteka delete(Long id);

}
