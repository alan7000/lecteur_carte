package lml.snir.controleacces.metier.entity;

import java.util.Objects;

public class Autorisation {
    private long id;
    private Salle salle;
    private Personne personne;
    private TimeSlot plageHoraire;

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

    /**
     * @return the plageHoraire
     */
    public TimeSlot getPlageHoraire() {
        return plageHoraire;
    }

    /**
     * @param plageHoraire the plageHoraire to set
     */
    public void setPlageHoraire(TimeSlot plageHoraire) {
        this.plageHoraire = plageHoraire;
    }
    
    @Override
    public String toString() {
        return "autorisation : " + this.personne.toString() + " salle " + this.salle.toString() + " horaire" + this.plageHoraire.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Autorisation)) {
            throw new ClassCastException();
        }
        return (o.hashCode() == this.hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.salle);
        hash = 97 * hash + Objects.hashCode(this.personne);
        hash = 97 * hash + Objects.hashCode(this.plageHoraire);
        return hash;
    }
}
