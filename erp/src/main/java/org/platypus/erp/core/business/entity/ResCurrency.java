package org.platypus.erp.core.business.entity;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@Entity
@Table(name= CoreTableName.currency)
@NamedQuery(name="ResCurrency.findAll", query="SELECT r FROM ResCurrency r")
public class ResCurrency extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Integer accuracy;

	private Boolean active;

	private Boolean base;
	@Column
	private String position;

	@Column
	private BigDecimal rounding;

	@Column(length=4)
	private String symbol;

//	//bi-directional many-to-one association to ResCompany
//	@OneToMany(mappedBy="currency")
//	private List<ResCompany> resCompanies;
//
//	//bi-directional many-to-one association to ResCountry
//	@OneToMany(mappedBy="currency")
//	private List<ResCountry> resCountries;
//
//	//bi-directional many-to-one association to ResCompany
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="company_id")
//	private ResCompany company;
//
//	//bi-directional many-to-one association to ResCurrencyRate
//	@OneToMany(mappedBy="currency")
//	private List<ResCurrencyRate> resCurrencyRates;


    //<editor-fold desc="Getter Setter">
    public Integer getAccuracy() {
        return accuracy;
    }

    public ResCurrency setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public ResCurrency setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Boolean getBase() {
        return base;
    }

    public ResCurrency setBase(Boolean base) {
        this.base = base;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public ResCurrency setPosition(String position) {
        this.position = position;
        return this;
    }

    public BigDecimal getRounding() {
        return rounding;
    }

    public ResCurrency setRounding(BigDecimal rounding) {
        this.rounding = rounding;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public ResCurrency setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }
    //</editor-fold>
}