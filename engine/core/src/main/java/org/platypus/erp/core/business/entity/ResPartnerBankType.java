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
@Table(name= CoreTableName.partnerBankType)
@NamedQuery(name="ResPartnerBankType.findAll", query="SELECT r FROM ResPartnerBankType r")
public class ResPartnerBankType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="format_layout")
	private String formatLayout;

//	//bi-directional many-to-one association to ResPartnerBankTypeField
//	@OneToMany(mappedBy="partnerBankType")
//	private List<ResPartnerBankTypeField> resPartnerBankTypeFields;



    //<editor-fold desc="Getter Setter">
    public String getFormatLayout() {
        return formatLayout;
    }

    public ResPartnerBankType setFormatLayout(String formatLayout) {
        this.formatLayout = formatLayout;
        return this;
    }
    //</editor-fold>
}