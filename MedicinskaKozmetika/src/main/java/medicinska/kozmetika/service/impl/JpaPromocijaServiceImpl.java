package medicinska.kozmetika.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.model.TipPromocije;
import medicinska.kozmetika.repository.PromocijaRepository;
import medicinska.kozmetika.service.PromocijaService;

@Service
@Transactional
public class JpaPromocijaServiceImpl implements PromocijaService {

	@Autowired
	private PromocijaRepository promocijaRepository;

	@Override
	public Promocija findOne(Long id) {
		return promocijaRepository.getOne(id);
	}

	@Override
	public Page<Promocija> search(LocalDate datum, TipPromocije tip, LocalTime vrijeme, Long apoteka, String naziv,
			String grad, Long lanac, int pageNum) {

		return promocijaRepository.search(datum, tip, vrijeme, apoteka, naziv, grad, lanac, PageRequest.of(pageNum, 5));
	}

	@Override
	public Page<Promocija> findAll(int pageNum) {

		return promocijaRepository.findAll(PageRequest.of(pageNum, 5));
	}

	@Override
	public Promocija save(Promocija promocija) {
		return promocijaRepository.save(promocija);
	}

	@Override
	public Promocija delete(Long id) {

		Promocija promocija = promocijaRepository.getOne(id);

		if (promocija != null) {
			promocijaRepository.delete(promocija);
		}

		return promocija;
	}

}
