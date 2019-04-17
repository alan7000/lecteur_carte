package lml.snir.controleacces.metier.sort;

import lml.snir.controleacces.metier.entity.Personne;
import java.util.Comparator;

/**
 *
 * @author fanou
 */
public class ComparatorByAge implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
        return o1.getAge() - o2.getAge();
    } 
    
}
