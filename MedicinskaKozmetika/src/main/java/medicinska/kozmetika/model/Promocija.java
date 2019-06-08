package medicinska.kozmetika.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Promocija {

	private Long id;

	private Apoteka apoteka;

	private LocalDate datum;
	
	private LocalTime vrijeme;
	
	private TipPromocije tipPromocije;

	private String dodatniOpisPromocije;

	
}
