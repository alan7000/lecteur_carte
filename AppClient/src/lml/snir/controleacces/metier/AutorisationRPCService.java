package lml.snir.controleacces.metier;

/**
 *
 * @author fanou
 */
public interface AutorisationRPCService {
    Boolean isAutorise(String badgeContent, Integer salle, String date) throws Exception;    
}
