package medicinska.kozmetika.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.service.LanacApotekaService;
import medicinska.kozmetika.support.LanacApotekaDTOToLanacApoteka;
import medicinska.kozmetika.support.LanacApotekaToLanacApotekaDTO;
import medicinska.kozmetika.web.dto.ApotekaDTO;
import medicinska.kozmetika.web.dto.LanacApotekaDTO;

@RestController
@RequestMapping(value = "/api/lanci-apoteka")
public class ApiLanacApotekaController {

	@Autowired
	private LanacApotekaService lanacApotekaService;

	@Autowired
	private LanacApotekaToLanacApotekaDTO toDTO;

	@Autowired
	private LanacApotekaDTOToLanacApoteka toLanacApoteka;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LanacApotekaDTO>> get(@RequestParam(required = false) String naziv,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<LanacApoteka> lanciApoteka;

		if (naziv != null) {
			naziv = '%' + naziv + '%';
			lanciApoteka = lanacApotekaService.search(naziv, pageNum);
		} else {
			lanciApoteka = lanacApotekaService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(lanciApoteka.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(lanciApoteka.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<LanacApotekaDTO> get(@PathVariable Long id) {
		LanacApoteka lanacApoteka = lanacApotekaService.findOne(id);

		if (lanacApoteka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(lanacApoteka), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LanacApotekaDTO> add(@Validated @RequestBody LanacApotekaDTO newDTO) {

		LanacApoteka lanacApoteka = toLanacApoteka.convert(newDTO);
		lanacApotekaService.save(lanacApoteka);

		return new ResponseEntity<>(toDTO.convert(lanacApoteka), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<LanacApotekaDTO> edit(@PathVariable Long id,
			@Validated @RequestBody LanacApotekaDTO editedDTO) {

		if (!id.equals(editedDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		LanacApoteka lanacApoteka = toLanacApoteka.convert(editedDTO);
		lanacApotekaService.save(lanacApoteka);

		return new ResponseEntity<>(toDTO.convert(lanacApoteka), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<LanacApotekaDTO> delete(@PathVariable Long id) {

		LanacApoteka deleted = lanacApotekaService.delete(id);
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
