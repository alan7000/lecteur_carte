package lml.snir.controleacces.client;

import lml.snir.controleacces.metier.AppControleAcces;
import lml.snir.controleacces.metier.MetierFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AppControleAccesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            AppControleAcces appControleAcces = MetierFactory.getAppControleAcces();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/MiniProject");

        Server jettyServer = new Server(9999);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(com.sun.jersey.spi.container.servlet.ServletContainer.class, "/rest/*");
        jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "lml.snir.controleacces.metier.rest.server, lml.rest.server");//Set the package where the services reside
        jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
