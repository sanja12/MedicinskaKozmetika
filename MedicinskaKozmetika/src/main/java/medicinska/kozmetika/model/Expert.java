package medicinska.kozmetika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Expert {

	@Id
	@GeneratedValue
	@Column
	private Long id;

	@Column
	private String ime;

	@Column
	private String prezime;

	@Column
	private String zvanje;

	@Column
	private String email;

	@Column
	private String telefon;

	@Column
	private String opis;

	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] slika;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

}
