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
@Table(name= CoreTableName.bank)
@NamedQuery(name="ResBank.findAll", query="SELECT r FROM ResBank r")
public class ResBank extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Boolean active;

	@Column(length=64)
	private String bic;

	@Column
	private String city;

	@Column
	private String email;

	@Column
	private String fax;
	@Column
	private String phone;

	@Column
	private String street;

	@Column
	private String street2;

	@Column(length=24)
	private String zip;

//	//bi-directional many-to-one association to ResCountry
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="country_id")
//	private ResCountry country;
//
//	//bi-directional many-to-one association to ResCountryState
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="state")
//	private ResCountryState countryState;
//
//	//bi-directional many-to-one association to ResPartnerBank
//	@OneToMany(mappedBy="bank")
//	private List<ResPartnerBank> resPartnerBanks;


    //<editor-fold desc="Getter Setter">
    public Boolean getActive() {
        return active;
    }

    public ResBank setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public ResBank setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ResBank setCity(String city) {
        this.city = city;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResBank setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public ResBank setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ResBank setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ResBank setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreet2() {
        return street2;
    }

    public ResBank setStreet2(String street2) {
        this.street2 = street2;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public ResBank setZip(String zip) {
        this.zip = zip;
        return this;
    }
    //</editor-fold>
}