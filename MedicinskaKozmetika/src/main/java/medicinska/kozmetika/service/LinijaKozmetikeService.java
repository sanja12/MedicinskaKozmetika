package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.LinijaKozmetike;

public interface LinijaKozmetikeService {

	List<LinijaKozmetike> findAll();

	LinijaKozmetike findOne(Long id);

	LinijaKozmetike save(LinijaKozmetike linijaKozmetike);

	LinijaKozmetike delete(Long id);

	List<LinijaKozmetike> findByNaziv(String naziv);

}
