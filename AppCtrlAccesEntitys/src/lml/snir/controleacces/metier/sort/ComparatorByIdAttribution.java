/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.sort;

import java.util.Comparator;
import lml.snir.controleacces.metier.entity.Attribution;

/**
 *
 * @author alan
 */
public class ComparatorByIdAttribution implements Comparator<Attribution>{

    @Override
    public int compare(Attribution t, Attribution t1) {
        return (int) (t.getId() - t1.getId());
    }

   

    
    
}
