package sit.int210.myhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyhostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyhostApplication.class, args);
		System.out.println(System.getProperty("os.name"));
	}

}
