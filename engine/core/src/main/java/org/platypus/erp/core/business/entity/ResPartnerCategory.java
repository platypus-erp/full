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
@Table(name= CoreTableName.partnerCategory)
@NamedQuery(name="ResPartnerCategory.findAll", query="SELECT r FROM ResPartnerCategory r")
public class ResPartnerCategory extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Boolean active;
	@Column(name="parent_left")
	private Integer parentLeft;

	@Column(name="parent_right")
	private Integer parentRight;

	//bi-directional many-to-one association to ResPartnerCategory
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="parent_id")
//	private ResPartnerCategory partnerCategory;
//
//	//bi-directional many-to-one association to ResPartnerCategory
//	@OneToMany(mappedBy="partnerCategory")
//	private List<ResPartnerCategory> resPartnerCategories;
//
//	//bi-directional many-to-many association to ResPartner
//	@ManyToMany
//	@JoinTable(
//		name="res_partner_res_partner_category_rel"
//		, joinColumns={
//			@JoinColumn(name="category_id", nullable=false)
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="partner_id", nullable=false)
//			}
//		)
//	private List<Partner> resPartners;


    //<editor-fold desc="Getter Setter">
    public Boolean getActive() {
        return active;
    }

    public ResPartnerCategory setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Integer getParentLeft() {
        return parentLeft;
    }

    public ResPartnerCategory setParentLeft(Integer parentLeft) {
        this.parentLeft = parentLeft;
        return this;
    }

    public Integer getParentRight() {
        return parentRight;
    }

    public ResPartnerCategory setParentRight(Integer parentRight) {
        this.parentRight = parentRight;
        return this;
    }
    //</editor-fold>
}