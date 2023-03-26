package sit.int210.myhost;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyhostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyhostApplication.class, args);
		
		System.out.println(System.getProperty("os.name"));

		try {
			Process process = Runtime.getRuntime().exec("hostname");
			
			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				System.exit(0);
			} else {
				//abnormal...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			}

		

}
