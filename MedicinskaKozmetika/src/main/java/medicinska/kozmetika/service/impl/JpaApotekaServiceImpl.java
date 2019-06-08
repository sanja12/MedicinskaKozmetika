package medicinska.kozmetika.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.repository.ApotekaRepository;
import medicinska.kozmetika.service.ApotekaService;

@Service
@Transactional
public class JpaApotekaServiceImpl implements ApotekaService {

	@Autowired
	private ApotekaRepository apotekaRepository;

	@Override
	public List<Apoteka> findAll() {
		return apotekaRepository.findAll();
	}

	@Override
	public Apoteka findOne(Long id) {
		return apotekaRepository.getOne(id);

	}

	@Override
	public Apoteka save(Apoteka apoteka) {
		return apotekaRepository.save(apoteka);
	}

	@Override
	public Apoteka delete(Long id) {

		Apoteka apoteka = apotekaRepository.getOne(id);

		if (apoteka != null) {
			apotekaRepository.delete(apoteka);
		}

		return apoteka;
	}

	@Override
	public List<Apoteka> findByLanacApotekaId(Long lanacApotekaId) {

		return apotekaRepository.findByLanacApotekaId(lanacApotekaId);
	}

	@Override
	public List<Apoteka> pretragaPoNazivuIliGradu(String naziv, String grad) {

		return apotekaRepository.pretragaPoNazivuIliGradu(naziv, grad);
	}

}
