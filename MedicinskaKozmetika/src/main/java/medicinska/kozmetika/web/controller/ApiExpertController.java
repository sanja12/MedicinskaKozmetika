package medicinska.kozmetika.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import medicinska.kozmetika.model.Expert;
import medicinska.kozmetika.model.UpitKorisnika;
import medicinska.kozmetika.service.ExpertService;

@RestController
@RequestMapping(value = "/api/eksperti")
public class ApiExpertController {

	@Autowired
	private ExpertService expertService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Expert>> get() {

		List<Expert> experti = expertService.findAll();

		return new ResponseEntity<>(experti, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Expert> get(@PathVariable Long id) {
		Expert expert = expertService.findOne(id);

		if (expert == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(expert, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Expert> add(@Validated @RequestBody Expert newExpert) {

		Expert expert = expertService.save(newExpert);

		return new ResponseEntity<>(expert, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Expert> add(@PathVariable Long id, @Validated @RequestBody Expert editedExpert) {

		if (!id.equals(editedExpert.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Expert expert = expertService.save(editedExpert);

		return new ResponseEntity<>(expert, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/send-message/{id}")
	public ResponseEntity<Void> edit(@PathVariable Long id, @Validated @RequestBody UpitKorisnika upitKorisnika) {

		Expert expert = expertService.findOne(upitKorisnika.getExpertId());

		if (expert == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		expertService.sendEmail(id, upitKorisnika);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Expert> delete(@PathVariable Long id) {

		Expert deleted = expertService.delete(id);
		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(DataIntegrityViolationException e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}