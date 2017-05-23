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
@Table(name= CoreTableName.currencyRate)
@NamedQuery(name="ResCurrencyRate.findAll", query="SELECT r FROM ResCurrencyRate r")
public class ResCurrencyRate extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column
	private BigDecimal rate;

//	//bi-directional many-to-one association to ResCurrency
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="currency_id")
//	private ResCurrency currency;


    //<editor-fold desc="Getter Setter">
    public BigDecimal getRate() {
        return rate;
    }

    public ResCurrencyRate setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }
    //</editor-fold>
}