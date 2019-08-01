package medicinska.kozmetika.web.dto;

import java.util.List;
import medicinska.kozmetika.model.MjestoPrimjene;
import medicinska.kozmetika.model.ProblemKoze;
import medicinska.kozmetika.model.TipKoze;
import medicinska.kozmetika.model.TipProizvoda;

public class ProizvodDTO {

	private Long id;

	private String naziv;

	private String kolicina;

	private LinijaKozmetikeDTO linijaKozmetikeDTO;

	private String opis;

	private TipProizvoda tipProizvoda;

	private List<TipKoze> tipoviKoze;

	private List<ProblemKoze> problemiKoze;

	private List<MjestoPrimjene> mjestaPrimjene;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	public LinijaKozmetikeDTO getLinijaKozmetikeDTO() {
		return linijaKozmetikeDTO;
	}

	public void setLinijaKozmetikeDTO(LinijaKozmetikeDTO linijaKozmetikeDTO) {
		this.linijaKozmetikeDTO = linijaKozmetikeDTO;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public TipProizvoda getTipProizvoda() {
		return tipProizvoda;
	}

	public void setTipProizvoda(TipProizvoda tipProizvoda) {
		this.tipProizvoda = tipProizvoda;
	}

	public List<TipKoze> getTipoviKoze() {
		return tipoviKoze;
	}

	public void setTipoviKoze(List<TipKoze> tipoviKoze) {
		this.tipoviKoze = tipoviKoze;
	}

	public List<ProblemKoze> getProblemiKoze() {
		return problemiKoze;
	}

	public void setProblemiKoze(List<ProblemKoze> problemiKoze) {
		this.problemiKoze = problemiKoze;
	}

	public List<MjestoPrimjene> getMjestaPrimjene() {
		return mjestaPrimjene;
	}

	public void setMjestaPrimjene(List<MjestoPrimjene> mjestaPrimjene) {
		this.mjestaPrimjene = mjestaPrimjene;
	}
}