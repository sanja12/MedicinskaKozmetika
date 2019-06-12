package medicinska.kozmetika.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Apoteka {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String naziv;

	@Column
	private String adresa;

	@Column
	private String grad;

	@Column
	private String telefon;

	@Column
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	private LanacApoteka lanacApoteka;

	@OneToMany(mappedBy = "apoteka", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Promocija> promocijes;

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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LanacApoteka getLanacApoteka() {
		return lanacApoteka;
	}

	public void setLanacApoteka(LanacApoteka lanacApoteka) {
		this.lanacApoteka = lanacApoteka;

		if (lanacApoteka != null && !lanacApoteka.getApoteke().contains(this)) {
			lanacApoteka.getApoteke().add(this);
		}
	}

	public List<Promocija> getPromocijes() {
		return promocijes;
	}

	public void setPromocijes(List<Promocija> promocijes) {
		this.promocijes = promocijes;
	}

}
