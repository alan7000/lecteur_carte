/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.sort;

import java.util.Comparator;
import lml.snir.controleacces.metier.entity.Autorisation;

/**
 *
 * @author alan
 */
public class ComparatorByIdAutorisation implements Comparator<Autorisation> {

    @Override
    public int compare(Autorisation t, Autorisation t1) {
        return (int) (t.getId() - t1.getId());
    }

}
