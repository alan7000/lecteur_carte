package lml.snir.controleacces.physique.io;

import java.util.Observable;

/**
 *
 * @author fanou
 */
public abstract class LecteurRFIDDriver extends Observable {

    public LecteurRFIDDriver() {
    }

    public abstract void open() throws Exception;

    public abstract void close() throws Exception;

}
