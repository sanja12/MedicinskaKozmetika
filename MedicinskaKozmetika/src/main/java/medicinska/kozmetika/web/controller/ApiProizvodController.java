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
import medicinska.kozmetika.model.Proizvod;
import medicinska.kozmetika.service.ProizvodService;
import medicinska.kozmetika.support.ProizvodDTOToProizvod;
import medicinska.kozmetika.support.ProizvodToProizvodDTO;
import medicinska.kozmetika.web.dto.ProizvodDTO;

@RestController
@RequestMapping(value = "/api/proizvodi")
public class ApiProizvodController {

	@Autowired
	private ProizvodService proizvodService;

	@Autowired
	private ProizvodToProizvodDTO toDTO;

	@Autowired
	private ProizvodDTOToProizvod toProizvod;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProizvodDTO>> get(@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Proizvod> proizvodi = proizvodService.findAll(pageNum);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(proizvodi.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(proizvodi.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ProizvodDTO> get(@PathVariable Long id) {
		Proizvod proizvod = proizvodService.findOne(id);

		if (proizvod == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(proizvod), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProizvodDTO> add(@Validated @RequestBody ProizvodDTO newDTO) {

		Proizvod proizvod = toProizvod.convert(newDTO);
		proizvodService.save(proizvod);

		return new ResponseEntity<>(toDTO.convert(proizvod), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<ProizvodDTO> edit(@PathVariable Long id, @Validated @RequestBody ProizvodDTO editedDTO) {

		if (!id.equals(editedDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Proizvod proizvod = toProizvod.convert(editedDTO);
		proizvodService.save(proizvod);

		return new ResponseEntity<>(toDTO.convert(proizvod), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ProizvodDTO> delete(@PathVariable Long id) {

		Proizvod deleted = proizvodService.delete(id);
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
