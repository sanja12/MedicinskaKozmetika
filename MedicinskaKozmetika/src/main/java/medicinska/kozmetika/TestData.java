package medicinska.kozmetika;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.model.Expert;
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.model.LinijaKozmetike;
import medicinska.kozmetika.model.Promocija;
import medicinska.kozmetika.model.TipPromocije;
import medicinska.kozmetika.service.ApotekaService;
import medicinska.kozmetika.service.ExpertService;
import medicinska.kozmetika.service.LanacApotekaService;
import medicinska.kozmetika.service.LinijaKozmetikeService;
import medicinska.kozmetika.service.PromocijaService;

@Component
public class TestData {

	@Autowired
	private ApotekaService apotekaService;

	@Autowired
	private LanacApotekaService lanacApotekaService;

	@Autowired
	private ExpertService expertService;

	@Autowired
	private PromocijaService promocijaService;

	@Autowired
	private LinijaKozmetikeService linijaKozmetikeService;

	@PostConstruct
	public void init() {

		LanacApoteka lanacApoteka = new LanacApoteka();

		lanacApoteka.setNaziv("BENU");
		lanacApoteka.setKontaktOsoba("Ana Anic");
		lanacApoteka.setEmail("benu@gmail.com");
		lanacApoteka.setTelefon("011/1111");

		lanacApotekaService.save(lanacApoteka);

		for (int i = 1; i <= 3; i++) {
			Apoteka apoteka = new Apoteka();

			apoteka.setNaziv("Benu0" + i);
			apoteka.setAdresa("Adresa" + i);
			apoteka.setEmail("benu0" + i + "@gmail.com");
			apoteka.setGrad("Beograd");
			apoteka.setTelefon("011/111" + i);
			apoteka.setLanacApoteka(lanacApoteka);

			// Ovo nece trebati poslije
			lanacApoteka.getApoteke().add(apoteka);

			Promocija promocija = new Promocija();
			promocija.setApoteka(apoteka);
			promocija.setDatum(LocalDate.now());
			promocija.setDodatniOpisPromocije("Opis");
			promocija.setTipPromocije(TipPromocije.POPUST);
			promocija.setVrijeme(LocalTime.now());

			apotekaService.save(apoteka);

			promocijaService.save(promocija);

		}

		Apoteka apoteka = new Apoteka();

		apoteka.setNaziv("Sunce");
		apoteka.setAdresa("Adresa");
		apoteka.setEmail("sunce@gmail.com");
		apoteka.setGrad("Novi Sad");
		apoteka.setTelefon("021/2222");

		apotekaService.save(apoteka);

		for (int i = 1; i <= 3; i++) {
			Expert expert = new Expert();
			expert.setEmail("sanja.pantic@hotmail.com");
			expert.setIme("Ime0" + i);
			expert.setPrezime("Prezime0" + i);
			expert.setTelefon("011/" + i + i);
			expert.setZvanje("mr Ph.");
			expert.setOpis("Opis0" + i);

			File file = new File("https://images.cdn2.stockunlimited.net/clipart/female-user-icon_1602624.jpg");
			byte[] bFile = new byte[(int) file.length()];
			expert.setSlika(bFile);

			expertService.save(expert);
		}

		for (int i = 0; i < 3; i++) {
			LinijaKozmetike linijaKozmetike = new LinijaKozmetike();

			linijaKozmetike.setDatumLansiranja(LocalDate.now());
			linijaKozmetike.setNaziv("Linija0" + i);
			linijaKozmetike.setOpis("Opis linije broj 0" + i);

			linijaKozmetikeService.save(linijaKozmetike);

		}

	}

}
