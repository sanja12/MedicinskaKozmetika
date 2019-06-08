package medicinska.kozmetika.model;

import java.time.LocalDate;
import java.util.Map;

public class LinijaKozmetike {
	
	private Long id;

	private String naziv;

	private LocalDate datumLansiranja;
	
	private Map<Long, Proizvod> proizvodi;
	
	private String opis;

}
