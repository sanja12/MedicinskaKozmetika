package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.Promocija;

public interface PromocijaService {

	List<Promocija> findAll();

	Promocija findOne(Long id);

	Promocija save(Promocija promocija);

	Promocija delete(Long id);

}
