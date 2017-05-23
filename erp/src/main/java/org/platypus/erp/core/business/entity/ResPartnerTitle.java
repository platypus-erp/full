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
@Table(name= CoreTableName.partnerTitle)
@NamedQuery(name="ResPartnerTitle.findAll", query="SELECT r FROM ResPartnerTitle r")
public class ResPartnerTitle extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private String domain;
	@Column
	private String shortcut;

//	//bi-directional many-to-one association to ResPartner
//	@OneToMany(mappedBy="partnerTitle")
//	private List<Partner> resPartners;


    //<editor-fold desc="Getter Setter">
    public String getDomain() {
        return domain;
    }

    public ResPartnerTitle setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getShortcut() {
        return shortcut;
    }

    public ResPartnerTitle setShortcut(String shortcut) {
        this.shortcut = shortcut;
        return this;
    }
    //</editor-fold>
}