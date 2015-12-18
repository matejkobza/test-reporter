package sk.trilobit.eskn.reporter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.net.InetAddress;
import java.net.UnknownHostException;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Inject
	private Environment environment;

	@PostConstruct
	public void initApplication() {

	}

	public static void main(String[] args) throws UnknownHostException
	{

		System.setProperty("server.port", "8080");

		SpringApplication app = new SpringApplicationBuilder(Application.class).properties("application-mode=standalone").application();
		app.setShowBanner(true);

		ApplicationContext appCtx = app.run(args);

		Environment env = appCtx.getEnvironment();

		ApplicationWebXml.logAppStarted(env, app);

		log.info("Access URLs:\n----------------------------------------------------------\n\t" +
						"Local: \t\thttp://127.0.0.1:{}\n\t" +
						"External: \thttp://{}:{}\n----------------------------------------------------------",
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"));

	}

}
