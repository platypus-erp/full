package org.platypus.erp.core.partner;

import org.platypus.erp.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import static org.platypus.erp.core.util.CoreTableName.coreAdresse;

/**
 * TODO Add JavaDoc
 *
 * @author Alexis PASQUIER
 * @author Alexandre SALAUN
 * @version 0.1
 * @since 0.1
 */
@Entity
@Table(name = coreAdresse)
public class Address extends AbstractEntity {

//    //bi-directional many-to-one association to ResCountry
//    @ManyToOne(fetch= FetchType.EAGER)
//    @JoinColumn(name="country_id")
//    private ResCountry country;

    @Column
    private String country;

    @Column
    private int number;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String street2;

    @Column
    private String street3;

    @Column
    private String street4;

    @Column
    private String streetType;

    @Column(length = 24)
    private String zipCode;

    @PrePersist
    public void prePersist(){
        super.name = number + " " + street + " "+ street2 + " " + city+ " "+ country;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Address setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getStreet2() {
        return street2;
    }

    public Address setStreet2(String street2) {
        this.street2 = street2;
        return this;
    }

    public String getStreet3() {
        return street3;
    }

    public Address setStreet3(String street3) {
        this.street3 = street3;
        return this;
    }

    public String getStreet4() {
        return street4;
    }

    public Address setStreet4(String street4) {
        this.street4 = street4;
        return this;
    }

    public String getStreetType() {
        return streetType;
    }

    public Address setStreetType(String streetType) {
        this.streetType = streetType;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }
}