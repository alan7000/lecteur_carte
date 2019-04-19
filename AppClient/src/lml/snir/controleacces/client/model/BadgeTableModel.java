/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Badge;

/**
 *
 * @author alan
 */
public class BadgeTableModel extends AbstractTableModel {

    private final String[] header = {"Badge", "Contenu"};
    private Badge[] badges;

    public BadgeTableModel(Badge[] badges) {
        this.badges = badges;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column];
    }

    @Override
    public int getRowCount() {
        return this.badges.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Badge badge = this.badges[rowIndex];
        switch (columnIndex) {
            case 0:
                return badge.getId();
            case 1:
                return badge.getContenu();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            Badge badge = this.badges[rowIndex];
            switch (columnIndex) {
                case 0:
                    badge.setId((long) aValue);
                    break;
                case 1:
                    badge.setContenu((String) aValue);
            }
            MetierFactory.getBadgeService().update(badge);
            this.fireTableDataChanged();
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
                return String.class;
        }
    }
    
    public Badge getBadgeAt(int rowIndex) {
        return this.badges[rowIndex];
    }

    public void update(Badge[] badges) {
        this.badges = badges;
        this.fireTableDataChanged();
    }
}
