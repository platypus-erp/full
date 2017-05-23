package org.platypus.erp.cdi.exception;

import org.platypus.erp.entity.AbstractEntity;

import java.lang.annotation.Annotation;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
public class TotoEntityBean extends RuntimeException{
    private TotoEntityBean(String message) {
        super(message);
    }

    public static TotoEntityBean notExtendException(Class entity) {
        return new TotoEntityBean(entity.getName() + " can't be used without extends " + AbstractEntity.class.getName());
    }

    public static TotoEntityBean notNotAnnotated(Class entity, Class<? extends Annotation> annotation) {
        return new TotoEntityBean(entity.getName() + " can't be used without the annotation " + annotation.getName());
    }
}
