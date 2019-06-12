package medicinska.kozmetika.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.web.dto.LinijaKozmetikeDTO;

@Component
public class LinijaKozmetikeToLinijaKozmetikeDTO implements Converter<LinijaKozmetike, LinijaKozmetikeDTO> {

	@Override
	public LinijaKozmetikeDTO convert(LinijaKozmetike source) {

		LinijaKozmetikeDTO dto = new LinijaKozmetikeDTO();

		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setDatumLansiranja(source.getDatumLansiranja());
		dto.setOpis(source.getOpis());

		return dto;
	}

	public List<LinijaKozmetikeDTO> convert(List<LinijaKozmetike> items) {
		List<LinijaKozmetikeDTO> ret = new ArrayList<>();

		for (LinijaKozmetike it : items) {
			ret.add(convert(it));
		}

		return ret;
	}
}