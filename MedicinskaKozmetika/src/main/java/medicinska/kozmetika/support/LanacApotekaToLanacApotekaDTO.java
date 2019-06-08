package medicinska.kozmetika.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.web.dto.LanacApotekaDTO;

@Component
public class LanacApotekaToLanacApotekaDTO implements Converter<LanacApoteka, LanacApotekaDTO> {

	@Override
	public LanacApotekaDTO convert(LanacApoteka source) {

		LanacApotekaDTO dto = new LanacApotekaDTO();

		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setKontaktOsoba(source.getKontaktOsoba());
		dto.setTelefon(source.getTelefon());
		dto.setEmail(source.getEmail());

		return dto;
	}

	public List<LanacApotekaDTO> convert(List<LanacApoteka> items) {
		List<LanacApotekaDTO> ret = new ArrayList<>();

		for (LanacApoteka it : items) {
			ret.add(convert(it));
		}

		return ret;
	}
}