package medicinska.kozmetika.web.controller;

import java.time.LocalDate;
import java.time.LocalTime;
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
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.model.TipPromocije;
import medicinska.kozmetika.service.PromocijaService;
import medicinska.kozmetika.support.PromocijaDTOToPromocija;
import medicinska.kozmetika.support.PromocijaToPromocijaDTO;
import medicinska.kozmetika.web.dto.PromocijaDTO;

@RestController
@RequestMapping(value = "/api/promocije")
public class ApiPromocijaController {

	@Autowired
	private PromocijaService promocijaService;

	@Autowired
	private PromocijaDTOToPromocija toPromocija;

	@Autowired
	private PromocijaToPromocijaDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PromocijaDTO>> get(@RequestParam(required = false) LocalDate datum,
			@RequestParam(required = false) TipPromocije tip, @RequestParam(required = false) LocalTime vrijeme,
			@RequestParam(required = false) Long apoteka, @RequestParam(required = false) String naziv,
			@RequestParam(required = false) String grad, @RequestParam(required = false) Long lanac,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Promocija> promocija;

		if (datum != null || tip != null || vrijeme != null || apoteka != null || naziv != null || grad != null
				|| lanac != null) {

			if (naziv != null) {
				naziv = "%" + naziv + "%";
			}

			if (grad != null) {
				grad = "%" + grad + "%";
			}

			promocija = promocijaService.search(datum, tip, vrijeme, apoteka, naziv, grad, lanac, pageNum);
		} else {
			promocija = promocijaService.findAll(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(promocija.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(promocija.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<PromocijaDTO> get(@PathVariable Long id) {
		Promocija promocija = promocijaService.findOne(id);

		if (promocija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(promocija), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PromocijaDTO> add(@Validated @RequestBody PromocijaDTO newDTO) {

		Promocija promocija = toPromocija.convert(newDTO);
		promocijaService.save(promocija);

		return new ResponseEntity<>(toDTO.convert(promocija), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<PromocijaDTO> edit(@PathVariable Long id, @Validated @RequestBody PromocijaDTO editedDTO) {

		if (!id.equals(editedDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Promocija promocija = toPromocija.convert(editedDTO);
		promocijaService.save(promocija);

		return new ResponseEntity<>(toDTO.convert(promocija), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<PromocijaDTO> delete(@PathVariable Long id) {

		Promocija deleted = promocijaService.delete(id);
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