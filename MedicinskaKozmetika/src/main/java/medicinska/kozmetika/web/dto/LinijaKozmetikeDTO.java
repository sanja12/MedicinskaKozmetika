package medicinska.kozmetika.web.dto;

import java.time.LocalDate;

public class LinijaKozmetikeDTO {

	private Long id;

	private String naziv;

	private LocalDate datumLansiranja;

	private String opis;

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

	public LocalDate getDatumLansiranja() {
		return datumLansiranja;
	}

	public void setDatumLansiranja(LocalDate datumLansiranja) {
		this.datumLansiranja = datumLansiranja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

}
