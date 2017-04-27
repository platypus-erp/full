package org.platypus.erp.core.business.entity;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@Entity
@Table(name= CoreTableName.requestLink)
@NamedQuery(name="ResRequestLink.findAll", query="SELECT r FROM ResRequestLink r")
public class ResRequestLink extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private String object;

	private Integer priority;

    //<editor-fold desc="Getter Setter">
    public String getObject() {
        return object;
    }

    public ResRequestLink setObject(String object) {
        this.object = object;
        return this;
    }

    public Integer getPriority() {
        return priority;
    }

    public ResRequestLink setPriority(Integer priority) {
        this.priority = priority;
        return this;
    }
    //</editor-fold>
}