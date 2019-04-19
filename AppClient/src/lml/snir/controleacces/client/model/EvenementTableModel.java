/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
public class EvenementTableModel extends AbstractTableModel {

    private final String[] header = {"Personne", "Salle", "Date", "Autoriser"};
    private Evenement[] evenements;

    public EvenementTableModel(Evenement[] evenements) {
        this.evenements = evenements;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.evenements.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Evenement evenement = this.evenements[rowIndex];
        switch (columnIndex) {
            case 0:
                return evenement.getPersonne();
            case 1:
                return evenement.getSalle();
            case 2:
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.format(evenement.getDate());
            case 3:
                return evenement.isAutorise();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Evenement evenement = this.evenements[rowIndex];
            switch (columnIndex) {
                case 0:
                    evenement.setPersonne((Personne) aValue);
                case 1:
                    evenement.setSalle((Salle) aValue);
                case 2:
                    evenement.setDate((Date) aValue);
                case 3:
                    evenement.setAutorise((boolean) aValue);
            }
            MetierFactory.getEvenementService().update(evenement);
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
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 3:
                return Boolean.class;
            default:
                return Object.class;
        }
    }

    public Evenement getEvenementAt(int rowIndex) {
        return this.evenements[rowIndex];
    }

    public void update(Evenement[] evenements) {
        this.evenements = evenements;
        this.fireTableDataChanged();
    }
}
