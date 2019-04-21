/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Day;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author alan
 */
public class TimeSlotTableModel extends AbstractTableModel {

    private final String[] header = {"Jour de début", "Heure de début", "Minute de début", "Jour de fin", "Heure de fin", "Minute de fin"};
    private TimeSlot[] timeSlots;

    public TimeSlotTableModel(TimeSlot[] timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public String getColumnName(int column) {
        return this.header[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.timeSlots.length;
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TimeSlot timeSlot = this.timeSlots[rowIndex];
        switch (columnIndex) {
            case 0:
                return timeSlot.getBeginDay();
            case 1:
                return timeSlot.getBeginHour();
            case 2:
                return timeSlot.getBeginMinutes();
            case 3:
                return timeSlot.getEndDay();
            case 4:
                return timeSlot.getEndHour();
            case 5:
                return timeSlot.getEndMinutes();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            TimeSlot timeSlot = this.timeSlots[rowIndex];
            switch (columnIndex) {
                case 0:
                    timeSlot.setBeginDay((Day) aValue);
                case 1:
                    timeSlot.setBeginHour((int) aValue);
                case 2:
                    timeSlot.setBeginMinutes((int) aValue);
                case 3:
                    timeSlot.setEndDay((Day) aValue);
                case 4:
                    timeSlot.setEndHour((int) aValue);
                case 5:
                    timeSlot.setEndMinutes((int) aValue);
            }
            MetierFactory.getTimeSlotService().update(timeSlot);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
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
            case 3:
                return Enum.class;
            default:
                return Integer.class;
        }
    }

    public TimeSlot getTimeSlotAt(int rowIndex) {
        return this.timeSlots[rowIndex];
    }

    public void update(TimeSlot[] timeSlots) {
        this.timeSlots = timeSlots;
        this.fireTableDataChanged();
    }
}
