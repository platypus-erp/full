package org.platypus.erp.core.business.entity;

import org.platypus.erp.core.util.CoreTableName;
import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;


/**
 * Created by Alexis PASQUIER and Alexandre SALAUN on 01/08/16.
 *
 * @since 0.1
 * @version 0.1
 */
@Entity
@Table(name= CoreTableName.countryGroup)
@NamedQuery(name="ResCountryGroup.findAll", query="SELECT r FROM ResCountryGroup r")
public class ResCountryGroup extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	//bi-directional many-to-many association to ResCountry
	@ManyToMany
	@JoinTable(
		name="res_country_res_country_group_rel"
		, joinColumns={
			@JoinColumn(name="res_country_group_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="res_country_id", nullable=false)
			}
		)
	private List<ResCountry> resCountries;

	public ResCountryGroup() {
	}

	public List<ResCountry> getResCountries() {
		return this.resCountries;
	}

	public void setResCountries(List<ResCountry> resCountries) {
		this.resCountries = resCountries;
	}

}