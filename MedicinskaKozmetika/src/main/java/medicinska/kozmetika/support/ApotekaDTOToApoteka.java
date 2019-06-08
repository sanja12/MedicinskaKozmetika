package medicinska.kozmetika.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.service.ApotekaService;
import medicinska.kozmetika.service.LanacApotekaService;
import medicinska.kozmetika.web.dto.ApotekaDTO;

@Component
public class ApotekaDTOToApoteka implements Converter<ApotekaDTO, Apoteka> {

	@Autowired
	private ApotekaService apotekaService;

	@Autowired
	private LanacApotekaService lanacApotekaService;

	@Override
	public Apoteka convert(ApotekaDTO dto) {
		Apoteka apoteka;

		if (dto.getId() == null) {
			apoteka = new Apoteka();
		} else {
			apoteka = apotekaService.findOne(dto.getId());
		}

		apoteka.setId(dto.getId());
		apoteka.setNaziv(dto.getNaziv());
		apoteka.setAdresa(dto.getAdresa());
		apoteka.setGrad(dto.getGrad());

		if (dto.getLanacApotekaId() != null) {
			apoteka.setLanacApoteka(lanacApotekaService.findOne(dto.getLanacApotekaId()));
		} else {
			apoteka.setLanacApoteka(null);
		}

		apoteka.setEmail(dto.getEmail());
		apoteka.setTelefon(dto.getTelefon());

		return apoteka;
	}

}
