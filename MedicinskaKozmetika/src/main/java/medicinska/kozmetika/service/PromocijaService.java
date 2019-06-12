package medicinska.kozmetika.service;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.model.TipPromocije;

public interface PromocijaService {

	Page<Promocija> search(
			@Param("datum") LocalDate datum, 
			@Param("tip") TipPromocije tip,
			@Param("vrijeme") LocalTime vrijeme,
			@Param("apoteka") Long apoteka,
			@Param("naziv") String naziv, 
			@Param("grad") String grad,
			@Param("lanac") Long lanac,
			int pageNum
			);
	
	Page<Promocija> findAll(int pageNum);

	Promocija findOne(Long id);

	Promocija save(Promocija promocija);

	Promocija delete(Long id);

}
