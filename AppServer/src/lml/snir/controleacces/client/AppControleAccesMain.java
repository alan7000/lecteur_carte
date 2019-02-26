package lml.snir.controleacces.client;

import lml.snir.controleacces.metier.AppControleAcces;
import lml.snir.controleacces.metier.MetierFactory;

public class AppControleAccesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            AppControleAcces appControleAcces = MetierFactory.getAppControleAcces();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
