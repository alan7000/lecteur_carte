package lml.snir.controleacces.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.snir.controleacces.metier.AutorisationRPCService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.physique.io.LecteurRFIDDriver;
import lml.snir.controleacces.physique.io.LecteurRFIDDriverID12Impl;

/**
 *
 * @author fanou
 */
public class AppBorne implements Observer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new AppBorne();
    }

    private AppBorne() throws Exception {
        LecteurRFIDDriver lecteur = new LecteurRFIDDriverID12Impl("/dev/ttyUSB0");
        lecteur.addObserver(this);
        lecteur.open();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Badge : " + arg);

        AutorisationRPCService rpc = MetierFactory.getAutorisationRPCService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        boolean ok;
        try {
            ok = rpc.isAutorise((String) arg, 458, sdf.format(new Date()));
            if (ok) {
                System.out.println("Ouvrir porte");
            } else {
                System.out.println("Desole pas le droit");
            }

        } catch (Exception ex) {
            Logger.getLogger(AppBorne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
