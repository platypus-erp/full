package org.platypus.erp.rest;

import javax.validation.ConstraintViolation;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@XmlRootElement
public class ConstraintViolationEntity {

    @XmlAttribute
    private final List<String> messages;

    public ConstraintViolationEntity(Set<ConstraintViolation<?>> constraintViolations) {
        messages = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
}
