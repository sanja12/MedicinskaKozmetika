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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.service.ApotekaService;
import medicinska.kozmetika.support.ApotekaDTOToApoteka;
import medicinska.kozmetika.support.ApotekaToApotekaDTO;
import medicinska.kozmetika.web.dto.ApotekaDTO;

@RestController
@RequestMapping(value = "/api/apoteke")
public class ApiApotekaController {

	@Autowired
	private ApotekaService apotekaService;

	@Autowired
	private ApotekaToApotekaDTO toDTO;

	@Autowired
	private ApotekaDTOToApoteka toApoteka;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ApotekaDTO>> get(@RequestParam(required = false) String naziv,
			@RequestParam(required = false) String grad) {

		List<Apoteka> apoteke;

		if (naziv != null || grad != null) {
			apoteke = apotekaService.pretragaPoNazivuIliGradu(naziv, grad);
		} else {
			apoteke = apotekaService.findAll();
		}

		return new ResponseEntity<>(toDTO.convert(apoteke), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ApotekaDTO> get(@PathVariable Long id) {
		Apoteka apoteka = apotekaService.findOne(id);

		if (apoteka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(apoteka), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApotekaDTO> add(@Validated @RequestBody ApotekaDTO newDTO) {

		Apoteka apoteka = toApoteka.convert(newDTO);
		apotekaService.save(apoteka);

		return new ResponseEntity<>(toDTO.convert(apoteka), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<ApotekaDTO> edit(@PathVariable Long id, @Validated @RequestBody ApotekaDTO editedDTO) {

		if (!id.equals(editedDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Apoteka apoteka = toApoteka.convert(editedDTO);
		apotekaService.save(apoteka);

		return new ResponseEntity<>(toDTO.convert(apoteka), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ApotekaDTO> delete(@PathVariable Long id) {

		Apoteka deleted = apotekaService.delete(id);
		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(DataIntegrityViolationException e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
