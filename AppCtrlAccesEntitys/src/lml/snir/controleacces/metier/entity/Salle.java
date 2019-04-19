package lml.snir.controleacces.metier.entity;

public class Salle {
    private long id;
    private long numero;
    private boolean protege;

    public Salle(){
        this.protege = false;
    }
    
    public Salle(boolean protege) {
        this.protege = protege;
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
     * @return the protege
     */
    public boolean isProtege() {
        return this.protege;
    }

    /**
     * @param protege the protege to set
     */
    public void setProtege(boolean protege) {
        this.protege = protege;
    }
    
    @Override
    public String toString() {
        String protec = " est protégée";
        if (!this.protege) {
            protec = " n'est pas protégée";
        }
        return this.id + protec;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = (int) (29 * hash + this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Salle)) {
            throw new ClassCastException();
        }
        return (o.hashCode() == this.hashCode());
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    
}
