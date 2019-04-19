/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client.model;

import java.awt.Component;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alan
 */
public class BooleanCellRenderer extends DefaultTableCellRenderer {

    private final Icon[] iconTrue;
    private final Icon[] iconFalse;
    private final int[] column;

    public BooleanCellRenderer(int[] column, String[] iconTrue, String[] iconFalse) throws IOException{
        super();
        this.column = column;
        this.iconTrue = new Icon[column.length];
        this.iconFalse = new Icon[column.length];
        for (int index = 0; index < column.length; index++) {
            this.iconTrue[index] = new ImageIcon(ImageIO.read(getClass().getResource(iconTrue[index])));
            this.iconFalse[index] = new ImageIcon(ImageIO.read(getClass().getResource(iconFalse[index])));
        }
    }
    
    private int getIndex(int column) {
        int index = -1;
        
        boolean find = false;
        int i = 0;
        while(i < this.column.length & !find) {
            if (find =(this.column[i] == column)){
                index = i;
            } else {
                i++;
            }
        }
                
        return index;
        
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        int index = this.getIndex(column);
        if (column != -1) {
            Boolean boolValue = (Boolean) value;
            
            super.setText("");
            
            if(boolValue) {
                super.setIcon(this.iconTrue[index]);
            } else {
                super.setIcon(this.iconFalse[index]);
            }
        }
        
        return this;
    }
    
    
}
