package medicinska.kozmetika.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.service.LanacApotekaService;
import medicinska.kozmetika.web.dto.LanacApotekaDTO;

@Component
public class LanacApotekaDTOToLanacApoteka implements Converter<LanacApotekaDTO, LanacApoteka> {

	@Autowired
	private LanacApotekaService lanacApotekaService;

	@Override
	public LanacApoteka convert(LanacApotekaDTO dto) {
		LanacApoteka lanacApoteka;

		if (dto.getId() == null) {
			lanacApoteka = new LanacApoteka();
		} else {
			lanacApoteka = lanacApotekaService.findOne(dto.getId());
		}

		lanacApoteka.setId(dto.getId());
		lanacApoteka.setNaziv(dto.getNaziv());
		lanacApoteka.setKontaktOsoba(dto.getKontaktOsoba());
		lanacApoteka.setTelefon(dto.getTelefon());
		lanacApoteka.setEmail(dto.getEmail());

		return lanacApoteka;
	}

}
