package medicinska.kozmetika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MedicinskaKozmetikaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MedicinskaKozmetikaApplication.class, args);
	}
}
