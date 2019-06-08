package medicinska.kozmetika.web.dto;

public class LanacApotekaDTO {

	private Long id;

	private String naziv;

	private String kontaktOsoba;

	private String email;

	private String telefon;

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

}
