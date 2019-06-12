package medicinska.kozmetika.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.web.dto.ApotekaDTO;
import medicinska.kozmetika.web.dto.PromocijaDTO;

@Component
public class PromocijaToPromocijaDTO implements Converter<Promocija, PromocijaDTO> {

	@Autowired
	private ApotekaToApotekaDTO toDTO;

	@Override
	public PromocijaDTO convert(Promocija source) {

		PromocijaDTO dto = new PromocijaDTO();

		ApotekaDTO apotekaDTO = toDTO.convert(source.getApoteka());

		dto.setId(source.getId());
		dto.setApotekaDTO(apotekaDTO);
		dto.setDatum(source.getDatum());
		dto.setDodatniOpisPromocije(source.getDodatniOpisPromocije());
		dto.setTipPromocije(source.getTipPromocije());
		dto.setVrijeme(source.getVrijeme());

		return dto;
	}

	public List<PromocijaDTO> convert(List<Promocija> items) {
		List<PromocijaDTO> ret = new ArrayList<>();

		for (Promocija it : items) {
			ret.add(convert(it));
		}

		return ret;
	}
}