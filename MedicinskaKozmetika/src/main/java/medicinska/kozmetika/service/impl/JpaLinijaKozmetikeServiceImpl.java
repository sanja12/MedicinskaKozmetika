package medicinska.kozmetika.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.repository.LinijaKozmetikeRepository;
import medicinska.kozmetika.service.LinijaKozmetikeService;

@Service
@Transactional
public class JpaLinijaKozmetikeServiceImpl implements LinijaKozmetikeService {

	@Autowired
	private LinijaKozmetikeRepository linijaKozmetikeRepository;

	@Override
	public LinijaKozmetike findOne(Long id) {

		return linijaKozmetikeRepository.getOne(id);

	}

	@Override
	public List<LinijaKozmetike> findAll() {

		return linijaKozmetikeRepository.findAll();
	}

	@Override
	public LinijaKozmetike save(LinijaKozmetike linijaKozmetike) {
		return linijaKozmetikeRepository.save(linijaKozmetike);
	}

	@Override
	public LinijaKozmetike delete(Long id) {

		LinijaKozmetike linijaKozmetike = linijaKozmetikeRepository.getOne(id);

		if (linijaKozmetike != null) {
			linijaKozmetikeRepository.delete(linijaKozmetike);
		}

		return linijaKozmetike;
	}

	@Override
	public List<LinijaKozmetike> findByNaziv(String naziv) {

		return linijaKozmetikeRepository.findByNaziv(naziv);
	}

}
