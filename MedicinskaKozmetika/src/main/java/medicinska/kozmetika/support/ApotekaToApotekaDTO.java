package medicinska.kozmetika.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.web.dto.ApotekaDTO;

@Component
public class ApotekaToApotekaDTO implements Converter<Apoteka, ApotekaDTO> {

	@Override
	public ApotekaDTO convert(Apoteka source) {

		ApotekaDTO dto = new ApotekaDTO();

		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setAdresa(source.getAdresa());
		dto.setGrad(source.getGrad());

		if (source.getLanacApoteka() != null) {
			dto.setLanacApotekaId(source.getLanacApoteka().getId());
			dto.setLanacApotekaNaziv(source.getLanacApoteka().getNaziv());
		}

		dto.setEmail(source.getEmail());
		dto.setTelefon(source.getTelefon());

		return dto;
	}

	public List<ApotekaDTO> convert(List<Apoteka> items) {
		List<ApotekaDTO> ret = new ArrayList<>();

		for (Apoteka it : items) {
			ret.add(convert(it));
		}

		return ret;
	}
}