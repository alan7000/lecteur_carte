/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.sort;

import java.util.Comparator;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
public class ComparatorByNumeroSalle implements Comparator<Salle>{

    @Override
    public int compare(Salle o1, Salle o2) {
        return (int) (o1.getNumero() - o2.getNumero());
    }
    
}
