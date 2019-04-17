/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.client;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;

/**
 *
 * @author jupiter
 */
class PersonneTableModel extends AbstractTableModel {

    private final String[] header = {"Nom", "Prenom", "Login", "Badge"};
    private Personne[] personnes;

    public PersonneTableModel(Personne[] personnes) {
        this.personnes = personnes;
    }

    @Override
    public String getColumnName(int i) {
        return this.header[i]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.personnes.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return this.header.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        Personne p = this.personnes[rowIndex];
        switch (columIndex) {
            case 0:
                return p.getNom();
            case 1:
                return p.getPrenom();
            case 2:
                String login = null;
                if (p instanceof Administrateur) {
                    Administrateur adm = (Administrateur) p;
                    login = adm.getLogin();
                }
                return login;
            case 3:
                boolean attribue = false;
                try {
                    attribue = (MetierFactory.getAttributionService().getByPersonne(p) != null);
                } catch (Exception e) {
                }
                return attribue;
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columIndex) {
        try {
            Personne p = this.personnes[rowIndex];
            switch (columIndex) {
                case 0:
                    p.setNom((String) aValue);
                    break;
                case 1:
                    p.setPrenom((String) aValue);
                    break;
                case 2:
                    if (p instanceof Administrateur) {
                        if (MetierFactory.getPersonneService().getByLogin((String) aValue) != null) {
                            throw new Exception("login indisponnible");
                        }
                        Administrateur adm = (Administrateur) p;
                        adm.setLogin((String) aValue);
                    }
            }

            MetierFactory.getPersonneService().update(p);
            this.fireTableDataChanged();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columIndex) {
        switch (columIndex) {
            default:
                return false;
        }
    }

    @Override
    public Class getColumnClass(int columIndex) {
        switch (columIndex) {
            case 3:
                return Boolean.class;
            default:
                return String.class;
        }
    }

    public Personne getPersonneAt(int rowIndex) {
        return this.personnes[rowIndex];
    }

    public void update(Personne[] personnes) {
        this.personnes = personnes;
        this.fireTableDataChanged();
    }

}
