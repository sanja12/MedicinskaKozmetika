package medicinska.kozmetika.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Promocija {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Apoteka apoteka;

	@Column
	private LocalDate datum;

	@Column
	private LocalTime vrijeme;

	@Column
	private TipPromocije tipPromocije;

	@Column
	private String dodatniOpisPromocije;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Apoteka getApoteka() {
		return apoteka;
	}

	public void setApoteka(Apoteka apoteka) {
		this.apoteka = apoteka;
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
