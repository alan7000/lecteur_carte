/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author alan
 */
public class AutorisationTableModel extends AbstractTableModel {

    private final String[] header = {"Salle", "Personne", "PlageHoraire"};
    private Autorisation[] autorisations;

    public AutorisationTableModel(Autorisation[] autorisations) {
        this.autorisations = autorisations;
    }

    @Override
    public String getColumnName(int i) {
        return this.header[i]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.autorisations.length;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return this.header.length;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autorisation autorisation = this.autorisations[rowIndex];
        switch(columnIndex) {
            case 0:
                return autorisation.getSalle();
            case 1:
                return autorisation.getPersonne();
            case 2:
                return autorisation.getPlageHoraire();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Autorisation autorisation = this.autorisations[rowIndex];
            switch(columnIndex) {
                case 0:
                    autorisation.setSalle((Salle) aValue);
                case 1:
                    autorisation.setPersonne((Personne) aValue);
                case 2:
                    autorisation.setPlageHoraire((TimeSlot) aValue);
            }
            
            MetierFactory.getAutorisationService().update(autorisation);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            default:
                return false;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return Object.class;
        }
    }
    
    public Autorisation getAutorisationAt(int rowIndex) {
        return this.autorisations[rowIndex];
    }
    
    public void update(Autorisation[] autorisations) {
        this.autorisations = autorisations;
        this.fireTableDataChanged();
    }
    
}
