package medicinska.kozmetika.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Singleton pattern
@Entity

public class MedicinskaKozmetika {

	@Id
	@GeneratedValue
	@Column
	private Integer intic = 1;
	
//	private static MedicinskaKozmetika medicinskaKozmetika = null;

	@Column
	private String naziv;

	@Column
	private String opis;

	@Column
	private Integer godinaOsnivanja;

//	@OneToMany(mappedBy = "medicinskaKozmetika", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<LinijaKozmetike> linijaKozmetike;

	private MedicinskaKozmetika() {
	}

//	public static MedicinskaKozmetika getMedicinskaKozmetika() {
//		if (medicinskaKozmetika == null)
//			medicinskaKozmetika = new MedicinskaKozmetika();
//
//		return medicinskaKozmetika;
//	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getGodinaOsnivanja() {
		return godinaOsnivanja;
	}

	public void setGodinaOsnivanja(Integer godinaOsnivanja) {
		this.godinaOsnivanja = godinaOsnivanja;
	}

//	public List<LinijaKozmetike> getLinijaKozmetike() {
//		return linijaKozmetike;
//	}
//
//	public void setLinijaKozmetike(List<LinijaKozmetike> linijaKozmetike) {
//		this.linijaKozmetike = linijaKozmetike;
//	}

}
