package lml.snir.controleacces.physique.io;

import lml.snir.controleacces.physique.ConfigReader;

/**
 *
 * @author fanou
 */
public final class PhysiqueIOFactory {

    private PhysiqueIOFactory() {}
    
    private static LecteurRFIDDriver lecteurRFIDDriver = null;
    synchronized public static LecteurRFIDDriver getLecteurRFID() throws Exception {
        if (lecteurRFIDDriver == null) {
            // lecture dans le fichier physiqueFactories.properties à la racine du projet de la propriété physique.io.borneDriver
            String drv = "lml.snir.controleacces.physique.io." + ConfigReader.getInstance("./physiqueFactories.properties").getProperty("lecteurRFID");
            String serialName = ConfigReader.getInstance("./physiqueFactories.properties").getProperty("serial");
            
            // instanciation via le nom de la classe
            lecteurRFIDDriver = (LecteurRFIDDriver) Class.forName(drv).getDeclaredConstructor(String.class).newInstance(serialName);
        }
        return lecteurRFIDDriver;
    }
    
}
/*
            // lecture dans le fichier physiqueFactories.properties à la racine du projet de la propriété physique.io.borneDriver
            String drv = "physique.io." + ConfigReader.getInstance("./physiqueFactories.properties").getProperty("physique.io.borneDriver");
            
            // instanciation via le nom de la classe
            borneDrv = (BorneDriver) Class.forName(drv).newInstance();
            
            // il se trouve que ce driver à un paramètre lui aussi dans le fichier properties ...
            String serialName = ConfigReader.getInstance("./physiqueFactories.properties").getProperty("physique.io.serial");
            Map parameters = new HashMap();
            parameters.put("serialName", serialName);
            borneDrv.openDriver(parameters);    
*/