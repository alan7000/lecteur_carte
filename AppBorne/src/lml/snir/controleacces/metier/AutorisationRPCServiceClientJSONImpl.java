package lml.snir.controleacces.metier;

import lml.jsonrpc.client.JsonRPCClient;
import lml.jsonrpc.core.transport.Transporter;

/**
 *
 * @author fanou
 */
public class AutorisationRPCServiceClientJSONImpl extends JsonRPCClient<AutorisationRPCService> implements AutorisationRPCService {

    protected AutorisationRPCServiceClientJSONImpl() {
    }

    public AutorisationRPCServiceClientJSONImpl(Transporter transporter) {
        System.out.println("AutorisationRPCServiceJSONImpl begin");
        super.setTransporter(transporter);
        System.out.println("AutorisationRPCServiceJSONImpl done");
    }

    @Override
    public Boolean isAutorise(String badgeContent, Integer salle, String date) throws Exception {
        return (Boolean) super.getObject("badgeContent", badgeContent, "salle", salle, "date", date);
    }
}
