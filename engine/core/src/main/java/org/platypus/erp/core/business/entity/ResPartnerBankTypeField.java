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
@Table(name= CoreTableName.partnerBankTypeField)
@NamedQuery(name="ResPartnerBankTypeField.findAll", query="SELECT r FROM ResPartnerBankTypeField r")
public class ResPartnerBankTypeField extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private Boolean readonly;

	private Boolean required;

	private Integer size;

//	//bi-directional many-to-one association to ResPartnerBankType
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="bank_type_id", nullable=false)
//	private ResPartnerBankType partnerBankType;


    //<editor-fold desc="Getter Setter">
    public Boolean getReadonly() {
        return readonly;
    }

    public ResPartnerBankTypeField setReadonly(Boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public Boolean getRequired() {
        return required;
    }

    public ResPartnerBankTypeField setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public ResPartnerBankTypeField setSize(Integer size) {
        this.size = size;
        return this;
    }
    //</editor-fold>
}