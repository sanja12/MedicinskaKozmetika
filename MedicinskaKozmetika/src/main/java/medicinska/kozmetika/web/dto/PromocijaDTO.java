package medicinska.kozmetika.web.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import medicinska.kozmetika.model.TipPromocije;

public class PromocijaDTO {

	private Long id;

	private ApotekaDTO apotekaDTO;

	private LocalDate datum;

	private LocalTime vrijeme;

	private TipPromocije tipPromocije;

	private String dodatniOpisPromocije;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApotekaDTO getApotekaDTO() {
		return apotekaDTO;
	}

	public void setApotekaDTO(ApotekaDTO apotekaDTO) {
		this.apotekaDTO = apotekaDTO;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public LocalTime getVrijeme() {
		return vrijeme;
	}

	public void setVrijeme(LocalTime vrijeme) {
		this.vrijeme = vrijeme;
	}

	public TipPromocije getTipPromocije() {
		return tipPromocije;
	}

	public void setTipPromocije(TipPromocije tipPromocije) {
		this.tipPromocije = tipPromocije;
	}

	public String getDodatniOpisPromocije() {
		return dodatniOpisPromocije;
	}

	public void setDodatniOpisPromocije(String dodatniOpisPromocije) {
		this.dodatniOpisPromocije = dodatniOpisPromocije;
	}

}
