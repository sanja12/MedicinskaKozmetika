package medicinska.kozmetika.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public LanacApoteka findOne(Long id) {
		return lanacApotekaRepository.getOne(id);

	}

	@Override
	public Page<LanacApoteka> findAll(int pageNum) {

		return lanacApotekaRepository.findAll(PageRequest.of(pageNum, 5));
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
	public Page<LanacApoteka> search(String naziv, int pageNum) {
		return lanacApotekaRepository.search(naziv, PageRequest.of(pageNum, 5));
	}

}
