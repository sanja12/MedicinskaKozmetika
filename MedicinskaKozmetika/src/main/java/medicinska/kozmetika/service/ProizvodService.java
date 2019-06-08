package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.Proizvod;

public interface ProizvodService {

	List<Proizvod> findAll();

	Proizvod findOne(Long id);

	Proizvod save(Proizvod proizvod);

	Proizvod delete(Long id);

}
