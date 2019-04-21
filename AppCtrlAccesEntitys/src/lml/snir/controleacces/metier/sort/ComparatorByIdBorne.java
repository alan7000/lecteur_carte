/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.sort;

import java.util.Comparator;
import lml.snir.controleacces.metier.entity.Borne;

/**
 *
 * @author alan
 */
public class ComparatorByIdBorne implements Comparator<Borne> {

    @Override
    public int compare(Borne o1, Borne o2) {
        return (int) (o1.getId() - o2.getId());
    }

}
