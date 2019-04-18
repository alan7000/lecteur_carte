package lml.snir.controleacces.metier.entity;

public class Attribution {
    private long id;
    private Badge badge;
    private Personne personne;

    public Attribution() {
    }

    
    
    public Attribution(Badge badge, Personne personne) {
        this.badge = badge;
        this.personne = personne;
    }   
    
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
     * @return the badge
     */
    public Badge getBadge() {
        return badge;
    }

    /**
     * @param badge the badge to set
     */
    public void setBadge(Badge badge) {
        this.badge = badge;
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
        return "Badge : " + this.badge.getId() + " attribué à " + this.personne.toString();
    }
}
