package lml.snir.controleacces.metier.entity;

import java.util.Objects;

public class Badge {

    private long id;
    private String contenu;

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
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.contenu;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Badge)) {
            throw new ClassCastException();
        }
        return (o.hashCode() == this.hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.contenu);
        return hash;
    }
}
