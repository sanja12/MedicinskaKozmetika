package medicinska.kozmetika.support;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import medicinska.kozmetika.model.Proizvod;
import medicinska.kozmetika.web.dto.ProizvodDTO;

@Component
public class ProizvodToProizvodDTO implements Converter<Proizvod, ProizvodDTO> {

	@Autowired
	private LinijaKozmetikeToLinijaKozmetikeDTO toLinijaKozmetikeDTO;

	@Override
	public ProizvodDTO convert(Proizvod source) {

		ProizvodDTO dto = new ProizvodDTO();

		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setKolicina(source.getKolicina());

		dto.setLinijaKozmetikeDTO(toLinijaKozmetikeDTO.convert(source.getLinijaKozmetike()));

		dto.setMjestaPrimjene(source.getMjestaPrimjene());
		dto.setOpis(source.getOpis());
		dto.setProblemiKoze(source.getProblemiKoze());
		dto.setTipoviKoze(source.getTipoviKoze());
		dto.setTipProizvoda(source.getTipProizvoda());

		return dto;
	}

	public List<ProizvodDTO> convert(List<Proizvod> items) {
		List<ProizvodDTO> ret = new ArrayList<>();

		for (Proizvod it : items) {
			ret.add(convert(it));
		}

		return ret;
	}
}