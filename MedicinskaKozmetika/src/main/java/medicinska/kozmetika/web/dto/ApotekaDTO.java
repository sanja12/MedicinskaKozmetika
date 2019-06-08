package medicinska.kozmetika.web.dto;

public class ApotekaDTO {

	private Long id;

	private String naziv;

	private String adresa;

	private String grad;

	private String telefon;

	private String email;

	private Long lanacApotekaId;

	private String lanacApotekaNaziv;

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

	public Long getLanacApotekaId() {
		return lanacApotekaId;
	}

	public void setLanacApotekaId(Long lanacApotekaId) {
		this.lanacApotekaId = lanacApotekaId;
	}

	public String getLanacApotekaNaziv() {
		return lanacApotekaNaziv;
	}

	public void setLanacApotekaNaziv(String lanacApotekaNaziv) {
		this.lanacApotekaNaziv = lanacApotekaNaziv;
	}

}
