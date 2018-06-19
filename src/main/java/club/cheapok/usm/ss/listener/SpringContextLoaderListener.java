package club.cheapok.usm.ss.listener;

import club.cheapok.usm.ss.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        sce.getServletContext().setAttribute("springContext", new AnnotationConfigApplicationContext(SpringConfiguration.class));
    }
}
