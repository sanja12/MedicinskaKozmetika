package medicinska.kozmetika;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import medicinska.kozmetika.model.Apoteka;
import medicinska.kozmetika.model.LanacApoteka;
import medicinska.kozmetika.service.ApotekaService;
import medicinska.kozmetika.service.LanacApotekaService;

@Component
public class TestData {

	@Autowired
	private ApotekaService apotekaService;

	@Autowired
	private LanacApotekaService lanacApotekaService;

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

			apotekaService.save(apoteka);

		}

		Apoteka apoteka = new Apoteka();

		apoteka.setNaziv("Sunce");
		apoteka.setAdresa("Adresa");
		apoteka.setEmail("sunce@gmail.com");
		apoteka.setGrad("Novi Sad");
		apoteka.setTelefon("021/2222");

		apotekaService.save(apoteka);

	}

}
