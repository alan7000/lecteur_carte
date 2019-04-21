package lml.snir.controleacces.client.serverRPC;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.jsonrpc.core.transport.Transporter;
import lml.jsonrpc.core.transport.tcp.TcpServerTransporter;
import lml.snir.controleacces.metier.AutorisationRPCService;
import lml.snir.controleacces.metier.MetierFactory;

/**
 *
 * @author fanou
 */
public class ServerMain extends Thread implements Runnable {

    public static void main(String[] args) throws Exception {

        // init transporter
        Map<String, Object> services = new HashMap<>();
        services.put(AutorisationRPCService.class.getName(), MetierFactory.getAutorisationRPCService());
        Transporter transporter = new TcpServerTransporter(9999, services); //new SerialServerTransporter(serial, services);
        transporter.open();

        System.out.println("wait");
        new ServerMain().start();
    }

    @Override
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
