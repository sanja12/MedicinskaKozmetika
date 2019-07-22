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
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.model.Proizvod;
import medicinska.kozmetika.service.LinijaKozmetikeService;
import medicinska.kozmetika.service.ProizvodService;
import medicinska.kozmetika.support.LinijaKozmetikeDTOToLinijaKozmetike;
import medicinska.kozmetika.support.LinijaKozmetikeToLinijaKozmetikeDTO;
import medicinska.kozmetika.support.ProizvodToProizvodDTO;
import medicinska.kozmetika.web.dto.ApotekaDTO;
import medicinska.kozmetika.web.dto.LinijaKozmetikeDTO;
import medicinska.kozmetika.web.dto.ProizvodDTO;

@RestController
@RequestMapping(value = "/api/linije-kozmetike")
public class ApiLinijaKozmetikeController {

	@Autowired
	private LinijaKozmetikeService linijaKozmetikeService;

	@Autowired
	private LinijaKozmetikeDTOToLinijaKozmetike toLinijaKozmetike;

	@Autowired
	private LinijaKozmetikeToLinijaKozmetikeDTO toDTO;

	@Autowired
	private ProizvodToProizvodDTO toProizvodDTO;

	@Autowired
	private ProizvodService proizvodService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LinijaKozmetikeDTO>> get() {

		List<LinijaKozmetike> linijeKozmetike;

		linijeKozmetike = linijaKozmetikeService.findAll();

		return new ResponseEntity<>(toDTO.convert(linijeKozmetike), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<LinijaKozmetikeDTO> get(@PathVariable Long id) {
		LinijaKozmetike linijaKozmetike = linijaKozmetikeService.findOne(id);

		if (linijaKozmetike == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(linijaKozmetike), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LinijaKozmetikeDTO> add(@Validated @RequestBody LinijaKozmetikeDTO newDTO) {

		LinijaKozmetike linijaKozmetike = toLinijaKozmetike.convert(newDTO);
		linijaKozmetikeService.save(linijaKozmetike);

		return new ResponseEntity<>(toDTO.convert(linijaKozmetike), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<LinijaKozmetikeDTO> edit(@PathVariable Long id,
			@Validated @RequestBody LinijaKozmetikeDTO editedDTO) {

		if (!id.equals(editedDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		LinijaKozmetike linijaKozmetike = toLinijaKozmetike.convert(editedDTO);
		linijaKozmetikeService.save(linijaKozmetike);

		return new ResponseEntity<>(toDTO.convert(linijaKozmetike), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<LinijaKozmetikeDTO> delete(@PathVariable Long id) {

		LinijaKozmetike deleted = linijaKozmetikeService.delete(id);
		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}/proizvodi")
	public ResponseEntity<List<ProizvodDTO>> get(@RequestParam Long id,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		if (id == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Page<Proizvod> proizvodi = proizvodService.search(id, pageNum);

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(proizvodi.getTotalPages()));

		return new ResponseEntity<>(toProizvodDTO.convert(proizvodi.getContent()), headers, HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(DataIntegrityViolationException e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}