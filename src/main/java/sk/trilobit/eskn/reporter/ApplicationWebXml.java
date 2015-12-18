package sk.trilobit.eskn.reporter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * This is a helper Java class that provides an alternative to creating a web.xml.
 */
public class ApplicationWebXml extends SpringBootServletInitializer implements WebApplicationInitializer
{

   private final static Logger logger = LoggerFactory.getLogger(ApplicationWebXml.class);

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
   {
      return application
               .showBanner(true)
               .sources(Application.class).properties("application-mode=container");
   }

   public static void logAppStarted(Environment env, SpringApplication application)
   {
      try
      {
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         printAppStarted(env, application, ps);
         logger.info(baos.toString("UTF-8"));
      }
      catch(UnsupportedEncodingException e)
      {
         e.printStackTrace();
      }
   }

   public static Resource getClasspathResource(SpringApplication application, String resName)
   {
      ResourceLoader resourceLoader = application.getResourceLoader() != null ? application.getResourceLoader() : new DefaultResourceLoader(application.getClassLoader());
      return resourceLoader.getResource(resName);
   }

   public static void printAppStarted(Environment env, SpringApplication application, PrintStream printStream)
   {
      Resource started = getClasspathResource(application, "started.txt");
      if(started.exists())
      {
         new ResourceBanner(started).printBanner(env, application.getClass(), printStream);
      }
   }

   @Override
   protected WebApplicationContext run(SpringApplication application)
   {
      WebApplicationContext retVal = super.run(application);

      logAppStarted(retVal.getEnvironment(), application);

      return retVal;
   }
}
