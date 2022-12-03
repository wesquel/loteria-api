package api.loteria.loteriaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LoteriaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoteriaApiApplication.class, args);
	}

}
