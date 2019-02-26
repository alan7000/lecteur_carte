package lml.snir.controleacces.metier.entity;

import java.util.Objects;

public class Personne {
    private long id;
    private String nom;
    private String prenom;

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
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    @Override
    public String toString() {
        return this.nom + " " + this.prenom;
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Personne)) {
            throw new ClassCastException();
        }
        return (o.hashCode() == this.hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nom);
        hash = 47 * hash + Objects.hashCode(this.prenom);
        return hash;
    }
}
