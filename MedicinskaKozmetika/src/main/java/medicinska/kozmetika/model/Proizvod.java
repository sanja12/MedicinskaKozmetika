package medicinska.kozmetika.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Proizvod {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String naziv;

	@Column
	private String kolicina;

	@ManyToOne(fetch = FetchType.EAGER)
	private LinijaKozmetike linijaKozmetike;

	@Column
	private String opis;

	@Enumerated(EnumType.STRING)
	private TipProizvoda tipProizvoda;

	@ElementCollection(targetClass = TipKoze.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "proizvod_tipoviKoze")
	@Column(name = "tipoviKoze")
	private List<TipKoze> tipoviKoze;

	@ElementCollection(targetClass = ProblemKoze.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "proizvod_problemiKoze")
	@Column(name = "problemiKoze")
	private List<ProblemKoze> problemiKoze;

	@ElementCollection(targetClass = MjestoPrimjene.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "proizvod_mjestaPrimjene")
	@Column(name = "mjestaPrimjene")
	private List<MjestoPrimjene> mjestaPrimjene;

	public Proizvod() {
		tipoviKoze = new ArrayList<>();
		problemiKoze = new ArrayList<>();
		mjestaPrimjene = new ArrayList<>();
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

	public String getKolicina() {
		return kolicina;
	}

	public void setKolicina(String kolicina) {
		this.kolicina = kolicina;
	}

	public LinijaKozmetike getLinijaKozmetike() {
		return linijaKozmetike;
	}

	public void setLinijaKozmetike(LinijaKozmetike linijaKozmetike) {
		this.linijaKozmetike = linijaKozmetike;
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
