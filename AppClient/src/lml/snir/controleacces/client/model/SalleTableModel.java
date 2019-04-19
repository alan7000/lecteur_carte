/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import java.util.EventListener;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
public class SalleTableModel extends AbstractTableModel {

    private final String[] header = {"Numero de la salle", "Protégé"};

    private Salle[] salles;

    public SalleTableModel(Salle[] salles) {
        this.salles = salles;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.salles.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Salle salle = this.salles[rowIndex];
        switch (columnIndex) {
            case 0:
                return salle.getNumero();
            case 1:
                return salle.isProtege();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Salle salle = this.salles[rowIndex];
            switch (columnIndex) {
                case 0:
                    salle.setNumero((long) aValue);
                case 1:
                    salle.setProtege((boolean) aValue);
            }
            MetierFactory.getSalleService().update(salle);
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
            case 0:
                return Long.class;
            case 1:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    public Salle getSalleAt(int rowIndex) {
        return this.salles[rowIndex];
    }
    
    public void update(Salle[] salles) {
        this.salles = salles;
        this.fireTableDataChanged();
    }
}
