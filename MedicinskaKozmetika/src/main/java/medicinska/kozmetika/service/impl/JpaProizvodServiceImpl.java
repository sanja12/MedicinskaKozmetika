package medicinska.kozmetika.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.Proizvod;
import medicinska.kozmetika.repository.ProizvodRepository;
import medicinska.kozmetika.service.ProizvodService;

@Service
@Transactional
public class JpaProizvodServiceImpl implements ProizvodService {

	@Autowired
	private ProizvodRepository proizvodRepository;

	@Override
	public Proizvod findOne(Long id) {
		return proizvodRepository.getOne(id);
	}

	@Override
	public Page<Proizvod> findAll(int pageNum) {

		return proizvodRepository.findAll(PageRequest.of(pageNum, 5));
	}

	@Override
	public Page<Proizvod> search(Long id, int pageNum) {

		return proizvodRepository.search(id, PageRequest.of(pageNum, 5));
	}

	@Override
	public Proizvod save(Proizvod proizvod) {
		return proizvodRepository.save(proizvod);
	}

	@Override
	public Proizvod delete(Long id) {

		Proizvod proizvod = proizvodRepository.getOne(id);

		if (proizvod != null) {
			proizvodRepository.delete(proizvod);
		}

		return proizvod;
	}

}
