package entities;

import java.io.Serializable;

/**
 * @author Alex Volochai
 */
public interface Identified<PK extends Serializable> {

    PK getId();

}

