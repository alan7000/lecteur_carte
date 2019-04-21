/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
public class BorneTableModel extends AbstractTableModel {

    private final String[] header = {"Id borne", "Salle"};
    private Borne[] bornes;

    public BorneTableModel(Borne[] borne) {
        this.bornes = borne;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.bornes.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Borne borne = this.bornes[rowIndex];
        switch (columnIndex) {
            case 0:
                return borne.getId();
            case 1:
                return borne.getSalle();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Borne borne = this.bornes[rowIndex];
            switch (columnIndex) {
                case 0:
                    borne.setId((long) aValue);
                case 1:
                    borne.setSalle((Salle) aValue);
            }
            MetierFactory.getBorneService().update(borne);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
        //To change body of generated methods, choose Tools | Templates.
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
            case 0:
                return Long.class;
            default:
                return Object.class;
        }
    }

    public Borne getBorneAt(int rowIndex) {
        return this.bornes[rowIndex];
    }

    public void update(Borne[] bornes) {
        this.bornes = bornes;
        this.fireTableDataChanged();
    }
}
