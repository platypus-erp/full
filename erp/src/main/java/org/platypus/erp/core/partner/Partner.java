package org.platypus.erp.core.partner;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@Entity
@Table(name= CoreTableName.partner)
@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM Partner r")
public class Partner extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Boolean active;

	@Column
	private String birthdate;

	private Integer color;

	@Column
	private String comment;

	@Column(name="credit_limit")
	private double creditLimit;

	private Boolean customer;

	@Column
	private String email;

	private Boolean employee;

	@Column
	private String fax;

	@Column
	private String function;

	@Column(name="is_company")
	private Boolean isCompany;

	@Column
	private String lang;

	@Column
	private String mobile;

	@Column
	private String phone;

	@Column
	private String type;

	@Column
	private String website;

    @Column
	private String gender;

//    @NotNull
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "main_adress_id")
    private Address mainAddress;


    //<editor-fold desc="Getter Setter">
    public Boolean getActive() {
        return active;
    }

    public Partner setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Partner setBirthdate(String birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public Integer getColor() {
        return color;
    }

    public Partner setColor(Integer color) {
        this.color = color;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Partner setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public Partner setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
        return this;
    }

    public Boolean getCustomer() {
        return customer;
    }

    public Partner setCustomer(Boolean customer) {
        this.customer = customer;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Partner setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getEmployee() {
        return employee;
    }

    public Partner setEmployee(Boolean employee) {
        this.employee = employee;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public Partner setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public String getFunction() {
        return function;
    }

    public Partner setFunction(String function) {
        this.function = function;
        return this;
    }

    public Boolean getCompany() {
        return isCompany;
    }

    public Partner setCompany(Boolean company) {
        isCompany = company;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public Partner setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Partner setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Partner setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getType() {
        return type;
    }

    public Partner setType(String type) {
        this.type = type;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Partner setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Partner setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Address getMainAddress() {
        return mainAddress;
    }

    public Partner setMainAddress(Address mainAdresse) {
        this.mainAddress = mainAdresse;
        return this;
    }
    //</editor-fold>
}