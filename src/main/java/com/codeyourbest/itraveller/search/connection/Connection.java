package com.codeyourbest.itraveller.search.connection;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String fromPlace;

    @Column(nullable = false)
    private String toPlace;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date validFrom = java.sql.Date.valueOf(LocalDate.parse("1970-01-01"));

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date validTo = java.sql.Date.valueOf(LocalDate.parse("3000-01-01"));

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}
