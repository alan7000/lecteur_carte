/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.sort;

import java.util.Comparator;
import lml.snir.controleacces.metier.entity.Evenement;

/**
 *
 * @author alan
 */
public class ComparatorByIdEvenement implements Comparator<Evenement>{

    @Override
    public int compare(Evenement o1, Evenement o2) {
        return (int) (o1.getId() - o2.getId());
    }
    
}
