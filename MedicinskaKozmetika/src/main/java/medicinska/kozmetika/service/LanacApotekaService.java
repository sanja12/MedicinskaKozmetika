package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.LanacApoteka;;

public interface LanacApotekaService {

	List<LanacApoteka> findAll();

	LanacApoteka findOne(Long id);

	LanacApoteka save(LanacApoteka lanacApoteka);

	LanacApoteka delete(Long id);

	List<LanacApoteka> findByNaziv(String naziv);

}
