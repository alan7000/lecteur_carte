/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;

/**
 *
 * @author alan
 */
public class AttributionTableModel extends AbstractTableModel{

    private final String[] header = {"Badge", "Personne"};
    private Attribution[] attributions;

    public AttributionTableModel(Attribution[] attributions) {
        this.attributions = attributions;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.attributions.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Attribution attribution = this.attributions[rowIndex];
        switch (columnIndex) {
            case 0:
                return attribution.getBadge();
            case 1:
                return attribution.getPersonne();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Attribution attribution = this.attributions[rowIndex];
            switch (columnIndex) {
                case 0:
                    attribution.setBadge((Badge) aValue);
                    break;
                case 1:
                    attribution.setPersonne((Personne) aValue);
            }
            MetierFactory.getAttributionService().update(attribution);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            default:
                return false;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
         switch(columnIndex){
             default:
                 return Object.class;
         }
    }
    
    public Attribution getAttributionAt(int rowIndex) {
        return this.attributions[rowIndex];
    }
    
    public void update(Attribution[] attributions) {
        this.attributions = attributions;
        this.fireTableDataChanged();
    }
}
