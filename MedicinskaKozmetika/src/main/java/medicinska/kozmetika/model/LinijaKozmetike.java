package medicinska.kozmetika.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LinijaKozmetike {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String naziv;

	@Column
	private LocalDate datumLansiranja;

	@Column
	private String opis;

	@OneToMany(mappedBy = "linijaKozmetike", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Proizvod> proizvodi;

	public LinijaKozmetike() {
		proizvodi = new ArrayList<>();
	}

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

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

}
