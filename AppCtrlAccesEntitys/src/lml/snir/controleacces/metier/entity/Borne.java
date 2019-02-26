package lml.snir.controleacces.metier.entity;

public class Borne {
    private long id;
    private Salle salle;

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

    @Override
    public String toString() {
        String st = "Borne : " + this.id + " " + this.salle;        
        
        return st;
    }
}
