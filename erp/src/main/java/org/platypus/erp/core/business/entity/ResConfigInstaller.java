package org.platypus.erp.core.business.entity;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

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
@Table(name= CoreTableName.configInstaller)
@NamedQuery(name="ResConfigInstaller.findAll", query="SELECT r FROM ResConfigInstaller r")
public class ResConfigInstaller extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	public ResConfigInstaller() {
	}
}