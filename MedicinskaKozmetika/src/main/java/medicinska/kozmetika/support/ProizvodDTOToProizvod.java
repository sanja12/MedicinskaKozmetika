package medicinska.kozmetika.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.model.Proizvod;
import medicinska.kozmetika.service.LinijaKozmetikeService;
import medicinska.kozmetika.service.ProizvodService;
import medicinska.kozmetika.web.dto.ProizvodDTO;

@Component
public class ProizvodDTOToProizvod implements Converter<ProizvodDTO, Proizvod> {

	@Autowired
	private ProizvodService proizvodService;

	@Autowired
	private LinijaKozmetikeService linijaKozmetikeService;

	@Override
	public Proizvod convert(ProizvodDTO dto) {

		LinijaKozmetike linijaKozmetike = linijaKozmetikeService.findOne(dto.getLinijaKozmetikeDTO().getId());

		if (linijaKozmetike == null) {
			System.out.println("Not a valid Proizvod!");
			return null;
		}

		Proizvod proizvod;

		if (dto.getId() == null) {
			proizvod = new Proizvod();

		} else {
			proizvod = proizvodService.findOne(dto.getId());
		}

		proizvod.setId(dto.getId());
		proizvod.setNaziv(dto.getNaziv());
		proizvod.setKolicina(dto.getKolicina());
		proizvod.setLinijaKozmetike(linijaKozmetike);
		proizvod.setMjestaPrimjene(dto.getMjestaPrimjene());
		proizvod.setOpis(dto.getOpis());
		proizvod.setProblemiKoze(dto.getProblemiKoze());
		proizvod.setTipoviKoze(dto.getTipoviKoze());
		proizvod.setTipProizvoda(dto.getTipProizvoda());

		return proizvod;
	}

}
