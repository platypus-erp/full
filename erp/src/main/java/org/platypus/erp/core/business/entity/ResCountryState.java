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
@Table(name= CoreTableName.countryState)
@NamedQuery(name="ResCountryState.findAll", query="SELECT r FROM ResCountryState r")
public class ResCountryState extends AbstractEntity {
	private static final long serialVersionUID = 1L;

//	//bi-directional many-to-one association to ResBank
//	@OneToMany(mappedBy="countryState")
//	private List<ResBank> resBanks;
//
//	//bi-directional many-to-one association to ResCountry
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="country_id", nullable=false)
//	private ResCountry country;
//
//	//bi-directional many-to-one association to ResPartner
//	@OneToMany(mappedBy="countryState")
//	private List<Partner> resPartners;
//
//	//bi-directional many-to-one association to ResPartnerBank
//	@OneToMany(mappedBy="countryState")
//	private List<ResPartnerBank> resPartnerBanks;

}