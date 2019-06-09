package medicinska.kozmetika.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Apoteka findOne(Long id) {
		return apotekaRepository.getOne(id);
	}

	@Override
	public Page<Apoteka> findAll(int pageNum) {

		return apotekaRepository.findAll(PageRequest.of(pageNum, 5));
	}

	@Override
	public Page<Apoteka> search(String naziv, String grad, Long lanac, int pageNum) {

		return apotekaRepository.search(naziv, grad, lanac, PageRequest.of(pageNum, 5));
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

}
