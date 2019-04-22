package lml.snir.controleacces.client;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.jsonrpc.core.transport.Transporter;
import lml.jsonrpc.core.transport.tcp.TcpServerTransporter;
import lml.snir.controleacces.client.serverRPC.ServerMain;
import lml.snir.controleacces.metier.AutorisationRPCService;
import lml.snir.controleacces.metier.MetierFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AppControleAccesMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
//        try {
//            AppControleAcces appControleAcces = MetierFactory.getAppControleAcces();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
/*
Démarrage du client rpc
*/

// init transporter
        Map<String, Object> services = new HashMap<>();
        services.put(AutorisationRPCService.class.getName(), MetierFactory.getAutorisationRPCService());
        Transporter transporter = new TcpServerTransporter(9998, services); //new SerialServerTransporter(serial, services);
        transporter.open();

        System.out.println("wait");
        new ServerMain().start();

/*
Démarrage du serveur restful
*/
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
    
    public void run() {
        System.out.println("run");
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
