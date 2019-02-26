package lml.snir.controleacces.metier;

import java.util.logging.Level;
import java.util.logging.Logger;
import lml.jsonrpc.core.transport.Transporter;
import lml.jsonrpc.core.transport.tcp.TcpClientTransporter;

public class MetierFactory {

    private MetierFactory() {
    }
    
    private static Transporter transporter = null;

    static {
        try {
            transporter = new TcpClientTransporter();
        } catch (Exception ex) {
            Logger.getLogger(MetierFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static AutorisationRPCService autorisationRPCService = new AutorisationRPCServiceClientJSONImpl(transporter);

    public static AutorisationRPCService getAutorisationRPCService() {
        return autorisationRPCService;
    }
}
