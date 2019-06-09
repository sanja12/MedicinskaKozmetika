package medicinska.kozmetika.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.Expert;
import medicinska.kozmetika.repository.ExpertRepository;
import medicinska.kozmetika.service.ExpertService;

@Service
@Transactional
public class JpaExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertRepository expertRepository;

	@Override
	public List<Expert> findAll() {
		return expertRepository.findAll();
	}

	@Override
	public Expert findOne(Long id) {
		return expertRepository.getOne(id);

	}

	@Override
	public Expert save(Expert expert) {
		return expertRepository.save(expert);
	}

	@Override
	public Expert delete(Long id) {

		Expert expert = expertRepository.getOne(id);

		if (expert != null) {
			expertRepository.delete(expert);
		}

		return expert;
	}

}
