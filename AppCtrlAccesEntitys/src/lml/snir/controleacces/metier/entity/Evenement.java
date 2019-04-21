package lml.snir.controleacces.metier.entity;

import java.util.Date;

public class Evenement {

    private long id;
    private Personne personne;
    private Salle salle;
    private Date date;
    private boolean autorise;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the salle
     */
    public Salle getSalle() {
        return salle;
    }

    /**
     * @param salle the salle to set
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the autorise
     */
    public boolean isAutorise() {
        return autorise;
    }

    /**
     * @param authoriser
     */
    public void setAutorise(boolean authoriser) {
        this.autorise = authoriser;
    }

    /**
     * @return the personne
     */
    public Personne getPersonne() {
        return personne;
    }

    /**
     * @param personne the personne to set
     */
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        String s = " accede à ";
        if (!this.autorise) {
            s = " n'a pas eu accès à ";
        }
        String str = "Event : " + this.personne + s + this.salle + " le " + this.date;
        return str;
    }
}
