package medicinska.kozmetika.model;

import java.util.List;

public abstract class Proizvod {
	
	private Long id;

	private String naziv;
	
	private String kolicina;
		
	private LinijaKozmetike linijaKozmetike;
	
	private TipProizvoda tipProizvoda;

	private List<TipKoze> tipoviKoze;

	private List<ProblemKoze> problemiKoze;
		
	private List<MjestoPrimjene> mjestaPrimjene;
	
	private String opis;
	
}
