package medicinska.kozmetika.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.service.LinijaKozmetikeService;
import medicinska.kozmetika.web.dto.LinijaKozmetikeDTO;

@Component
public class LinijaKozmetikeDTOToLinijaKozmetike implements Converter<LinijaKozmetikeDTO, LinijaKozmetike> {

	@Autowired
	private LinijaKozmetikeService linijaKozmetikeService;

	@Override
	public LinijaKozmetike convert(LinijaKozmetikeDTO dto) {
		LinijaKozmetike linijaKozmetike;

		if (dto.getId() == null) {
			linijaKozmetike = new LinijaKozmetike();
		} else {
			linijaKozmetike = linijaKozmetikeService.findOne(dto.getId());
		}

		linijaKozmetike.setId(dto.getId());
		linijaKozmetike.setNaziv(dto.getNaziv());
		linijaKozmetike.setDatumLansiranja(dto.getDatumLansiranja());
		linijaKozmetike.setOpis(dto.getOpis());

		return linijaKozmetike;
	}

}
