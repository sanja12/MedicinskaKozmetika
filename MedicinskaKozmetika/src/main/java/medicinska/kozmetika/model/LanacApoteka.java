package medicinska.kozmetika.model;

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
public class LanacApoteka {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String naziv;

	@Column
	private String kontaktOsoba;

	@Column
	private String email;

	@Column
	private String telefon;

	@OneToMany(mappedBy = "lanacApoteka", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Apoteka> apoteke;

	public LanacApoteka() {
		apoteke = new ArrayList<>();
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

	public List<Apoteka> getApoteke() {
		return apoteke;
	}

	public void setApoteke(List<Apoteka> apoteke) {
		this.apoteke = apoteke;
	}

	public String getKontaktOsoba() {
		return kontaktOsoba;
	}

	public void setKontaktOsoba(String kontaktOsoba) {
		this.kontaktOsoba = kontaktOsoba;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void addApoteka(Apoteka apoteka) {
		this.apoteke.add(apoteka);

		if (!this.equals(apoteka.getLanacApoteka())) {
			apoteka.setLanacApoteka(this);
		}
	}

}
