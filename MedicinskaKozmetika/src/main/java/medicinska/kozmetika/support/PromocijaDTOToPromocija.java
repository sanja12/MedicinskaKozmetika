package medicinska.kozmetika.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.service.PromocijaService;
import medicinska.kozmetika.web.dto.PromocijaDTO;

@Component
public class PromocijaDTOToPromocija implements Converter<PromocijaDTO, Promocija> {

	@Autowired
	private PromocijaService promocijaService;

	@Autowired
	private ApotekaDTOToApoteka toApoteka;

	@Override
	public Promocija convert(PromocijaDTO dto) {
		Promocija promocija;

		if (dto.getId() == null) {
			promocija = new Promocija();
		} else {
			promocija = promocijaService.findOne(dto.getId());
		}

		Apoteka apoteka = toApoteka.convert(dto.getApotekaDTO());

		promocija.setId(dto.getId());
		promocija.setApoteka(apoteka);
		promocija.setDatum(dto.getDatum());
		promocija.setDodatniOpisPromocije(dto.getDodatniOpisPromocije());
		promocija.setTipPromocije(dto.getTipPromocije());
		promocija.setVrijeme(dto.getVrijeme());

		return promocija;
	}

}
