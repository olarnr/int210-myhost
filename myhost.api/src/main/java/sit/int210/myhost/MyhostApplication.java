package sit.int210.myhost;

import sit.int210.myhost.utils.FrontendProperties;
import sit.int210.myhost.utils.ProcessManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyhostApplication {
	//@Autowired
	//private FrontendProperties fep;

	public static void main(String[] args) {
		SpringApplication.run(MyhostApplication.class, args);

		//FrontendProperties fep = new FrontendProperties();
		//System.out.println(fep.getUrl());

		//System.out.println(url);
		System.out.println(System.getProperty("os.name"));

		ProcessManager p = new ProcessManager("hostname -a");
		System.out.printf("Executing '%s'%nThe exit value is %d%n", p.getCommand(), p.executeCommand());
		System.out.printf("The output is %s", p.getOut());
	}
}
