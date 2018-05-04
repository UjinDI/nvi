package ru.nvg.simple.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Doc")
public class Doc {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JacksonXmlProperty(localName = "num", isAttribute = true)
    private Long id;

    @JacksonXmlProperty(localName = "amount", isAttribute = true)
    private BigDecimal doc_amount;

    @JacksonXmlProperty(localName = "companyInn", isAttribute = true)
    private Long doc_inn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id")
    private Package aPackage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organizationisn")
    private Organization organization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDoc_amount() {
        return doc_amount;
    }

    public void setDoc_amount(BigDecimal doc_amount) {
        this.doc_amount = doc_amount;
    }

    public Long getDoc_inn() {
        return doc_inn;
    }

    public void setDoc_inn(Long doc_inn) {
        this.doc_inn = doc_inn;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
