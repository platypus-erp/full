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
@Table(name= CoreTableName.partnerBank)
@NamedQuery(name="ResPartnerBank.findAll", query="SELECT r FROM ResPartnerBank r")
public class ResPartnerBank extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="acc_number", nullable=false, length=64)
	private String accNumber;

	@Column(name="bank_bic", length=16)
	private String bankBic;

	@Column(name="bank_name")
	private String bankName;

	@Column
	private String city;

	private Boolean footer;

	@Column(name="owner_name")
	private String ownerName;

	private Integer sequence;

	@Column(nullable=false)
	private String state;

	@Column
	private String street;

	@Column(length=24)
	private String zip;

//	//bi-directional many-to-one association to ResBank
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="bank")
//	private ResBank bank;
//
//	//bi-directional many-to-one association to ResCompany
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="company_id")
//	private ResCompany company;
//
//	//bi-directional many-to-one association to ResCountry
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="country_id")
//	private ResCountry country;
//
//	//bi-directional many-to-one association to ResCountryState
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="state_id")
//	private ResCountryState countryState;
//
//	//bi-directional many-to-one association to ResPartner
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="partner_id")
//	private Partner partner;
//
//	//bi-directional many-to-one association to ResUser
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="create_uid")
//	private ResUser resUser1;
//
//	//bi-directional many-to-one association to ResUser
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="write_uid")
//	private ResUser resUser2;


    public String getAccNumber() {
        return accNumber;
    }

    public ResPartnerBank setAccNumber(String accNumber) {
        this.accNumber = accNumber;
        return this;
    }

    public String getBankBic() {
        return bankBic;
    }

    public ResPartnerBank setBankBic(String bankBic) {
        this.bankBic = bankBic;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public ResPartnerBank setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ResPartnerBank setCity(String city) {
        this.city = city;
        return this;
    }

    public Boolean getFooter() {
        return footer;
    }

    public ResPartnerBank setFooter(Boolean footer) {
        this.footer = footer;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ResPartnerBank setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public Integer getSequence() {
        return sequence;
    }

    public ResPartnerBank setSequence(Integer sequence) {
        this.sequence = sequence;
        return this;
    }

    public String getState() {
        return state;
    }

    public ResPartnerBank setState(String state) {
        this.state = state;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ResPartnerBank setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public ResPartnerBank setZip(String zip) {
        this.zip = zip;
        return this;
    }
}