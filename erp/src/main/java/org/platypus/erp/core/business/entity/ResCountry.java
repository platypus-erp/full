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
@Table(name= CoreTableName.country)
@NamedQuery(name="ResCountry.findAll", query="SELECT r FROM ResCountry r")
public class ResCountry extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="address_format")
	private String addressFormat;

	private byte[] image;

//	//bi-directional many-to-one association to ResBank
//	@OneToMany(mappedBy="country")
//	private List<ResBank> resBanks;
//
//	//bi-directional many-to-one association to ResCurrency
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="currency_id")
//	private ResCurrency currency;
//
//	//bi-directional many-to-many association to ResCountryGroup
//	@ManyToMany(mappedBy="resCountries")
//	private List<ResCountryGroup> resCountryGroups;
//
//	//bi-directional many-to-one association to ResCountryState
//	@OneToMany(mappedBy="country")
//	private List<ResCountryState> resCountryStates;
//
//	//bi-directional many-to-one association to ResPartner
//	@OneToMany(mappedBy="country")
//	private List<Partner> resPartners;
//
//	//bi-directional many-to-one association to ResPartnerBank
//	@OneToMany(mappedBy="country")
//	private List<ResPartnerBank> resPartnerBanks;



    //<editor-fold desc="Getter Setter">
    public String getAddressFormat() {
        return addressFormat;
    }

    public ResCountry setAddressFormat(String addressFormat) {
        this.addressFormat = addressFormat;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public ResCountry setImage(byte[] image) {
        this.image = image;
        return this;
    }
    //</editor-fold>
}