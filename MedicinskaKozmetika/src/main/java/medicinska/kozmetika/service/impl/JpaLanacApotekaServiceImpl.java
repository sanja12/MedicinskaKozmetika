package medicinska.kozmetika.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.repository.LanacApotekaRepository;
import medicinska.kozmetika.service.LanacApotekaService;

@Service
@Transactional
public class JpaLanacApotekaServiceImpl implements LanacApotekaService {

	@Autowired
	private LanacApotekaRepository lanacApotekaRepository;

	@Override
	public List<LanacApoteka> findAll() {
		return lanacApotekaRepository.findAll();
	}

	@Override
	public LanacApoteka findOne(Long id) {
		return lanacApotekaRepository.getOne(id);

	}

	@Override
	public LanacApoteka save(LanacApoteka lanacApoteka) {
		return lanacApotekaRepository.save(lanacApoteka);
	}

	@Override
	public LanacApoteka delete(Long id) {

		LanacApoteka lanacApoteka = lanacApotekaRepository.getOne(id);

		if (lanacApoteka != null) {
			lanacApotekaRepository.delete(lanacApoteka);
		}

		return lanacApoteka;
	}

	@Override
	public List<LanacApoteka> findByNaziv(String naziv) {

		return lanacApotekaRepository.findByNaziv(naziv);
	}

}
