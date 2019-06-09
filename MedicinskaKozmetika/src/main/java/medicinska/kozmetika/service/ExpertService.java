package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.Expert;

public interface ExpertService {

	List<Expert> findAll();

	Expert findOne(Long id);

	Expert save(Expert expert);

	Expert delete(Long id);
	
}
