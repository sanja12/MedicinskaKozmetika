package medicinska.kozmetika.service;

import java.util.List;
import medicinska.kozmetika.model.Expert;
import medicinska.kozmetika.model.UpitKorisnika;

public interface ExpertService {

	List<Expert> findAll();

	Expert findOne(Long id);

	Expert save(Expert expert);

	Expert delete(Long id);
	
	void sendEmail(Long id, UpitKorisnika upitKorisnika);
	
}
