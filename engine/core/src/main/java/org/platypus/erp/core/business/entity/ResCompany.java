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
@Table(name= CoreTableName.company)
@NamedQuery(name="ResCompany.findAll", query="SELECT r FROM ResCompany r")
public class ResCompany extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="account_no")
	private String accountNo;

	@Column(name="company_registry", length=64)
	private String companyRegistry;

	@Column(name="custom_footer")
	private Boolean customFooter;

	@Column(length=64)
	private String email;

	@Column(name="logo_web")
	private byte[] logoWeb;

	@Column(length=64)
	private String phone;

	@Column(name="rml_footer")
	private String rmlFooter;

	@Column(name="rml_header", nullable=false)
	private String rmlHeader;

	@Column(name="rml_header1")
	private String rmlHeader1;

	@Column(name="rml_header2", nullable=false)
	private String rmlHeader2;

	@Column(name="rml_header3", nullable=false)
	private String rmlHeader3;

	@Column(name="rml_paper_format", nullable=false)
	private String rmlPaperFormat;

//	//bi-directional many-to-one association to ResCompany
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="parent_id")
//	private ResCompany company;
//
//	//bi-directional many-to-one association to ResCompany
//	@OneToMany(mappedBy="company")
//	private List<ResCompany> resCompanies;
//
//	//bi-directional many-to-one association to ResCurrency
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="currency_id", nullable=false)
//	private ResCurrency currency;
//
//	//bi-directional many-to-one association to ResFont
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="font")
//	private ResFont resFont;
//
//	//bi-directional many-to-one association to ResPartner
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="partner_id", nullable=false)
//	private Partner partner;
//
//	//bi-directional many-to-many association to ResUser
//	@ManyToMany(mappedBy="resCompanies3")
//	private List<ResUser> resUsers1;
//
//	//bi-directional many-to-one association to ResCurrency
//	@OneToMany(mappedBy="company")
//	private List<ResCurrency> resCurrencies;
//
//	//bi-directional many-to-one association to ResPartner
//	@OneToMany(mappedBy="company")
//	private List<Partner> resPartners;
//
//	//bi-directional many-to-one association to ResPartnerBank
//	@OneToMany(mappedBy="company")
//	private List<ResPartnerBank> resPartnerBanks;
//
//	//bi-directional many-to-one association to ResUser
//	@OneToMany(mappedBy="company")
//	private List<ResUser> resUsers2;


    //<editor-fold desc="Getter Setter">
    public String getAccountNo() {
        return accountNo;
    }

    public ResCompany setAccountNo(String accountNo) {
        this.accountNo = accountNo;
        return this;
    }

    public String getCompanyRegistry() {
        return companyRegistry;
    }

    public ResCompany setCompanyRegistry(String companyRegistry) {
        this.companyRegistry = companyRegistry;
        return this;
    }

    public Boolean getCustomFooter() {
        return customFooter;
    }

    public ResCompany setCustomFooter(Boolean customFooter) {
        this.customFooter = customFooter;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ResCompany setEmail(String email) {
        this.email = email;
        return this;
    }

    public byte[] getLogoWeb() {
        return logoWeb;
    }

    public ResCompany setLogoWeb(byte[] logoWeb) {
        this.logoWeb = logoWeb;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ResCompany setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getRmlFooter() {
        return rmlFooter;
    }

    public ResCompany setRmlFooter(String rmlFooter) {
        this.rmlFooter = rmlFooter;
        return this;
    }

    public String getRmlHeader() {
        return rmlHeader;
    }

    public ResCompany setRmlHeader(String rmlHeader) {
        this.rmlHeader = rmlHeader;
        return this;
    }

    public String getRmlHeader1() {
        return rmlHeader1;
    }

    public ResCompany setRmlHeader1(String rmlHeader1) {
        this.rmlHeader1 = rmlHeader1;
        return this;
    }

    public String getRmlHeader2() {
        return rmlHeader2;
    }

    public ResCompany setRmlHeader2(String rmlHeader2) {
        this.rmlHeader2 = rmlHeader2;
        return this;
    }

    public String getRmlHeader3() {
        return rmlHeader3;
    }

    public ResCompany setRmlHeader3(String rmlHeader3) {
        this.rmlHeader3 = rmlHeader3;
        return this;
    }

    public String getRmlPaperFormat() {
        return rmlPaperFormat;
    }

    public ResCompany setRmlPaperFormat(String rmlPaperFormat) {
        this.rmlPaperFormat = rmlPaperFormat;
        return this;
    }
    //</editor-fold>
}