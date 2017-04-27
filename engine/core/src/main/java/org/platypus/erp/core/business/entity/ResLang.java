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
@Table(name= CoreTableName.lang)
@NamedQuery(name="ResLang.findAll", query="SELECT r FROM ResLang r")
public class ResLang extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private Boolean active;

	@Column(name="date_format", nullable=false)
	private String dateFormat;

	@Column(name="decimal_point", nullable=false)
	private String decimalPoint;

	@Column(nullable=false)
	private String direction;

	@Column(nullable=false)
	private String grouping;

	@Column(name="iso_code", length=16)
	private String isoCode;
	@Column(name="thousands_sep")
	private String thousandsSep;

	@Column(name="time_format", nullable=false)
	private String timeFormat;

	private Boolean translatable;

    //<editor-fold desc="Getter Setter">
    public Boolean getActive() {
        return active;
    }

    public ResLang setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public ResLang setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public String getDecimalPoint() {
        return decimalPoint;
    }

    public ResLang setDecimalPoint(String decimalPoint) {
        this.decimalPoint = decimalPoint;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public ResLang setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getGrouping() {
        return grouping;
    }

    public ResLang setGrouping(String grouping) {
        this.grouping = grouping;
        return this;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public ResLang setIsoCode(String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    public String getThousandsSep() {
        return thousandsSep;
    }

    public ResLang setThousandsSep(String thousandsSep) {
        this.thousandsSep = thousandsSep;
        return this;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public ResLang setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    public Boolean getTranslatable() {
        return translatable;
    }

    public ResLang setTranslatable(Boolean translatable) {
        this.translatable = translatable;
        return this;
    }
    //</editor-fold>
}