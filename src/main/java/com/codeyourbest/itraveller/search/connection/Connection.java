package com.codeyourbest.itraveller.search.connection;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
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

    private Connection (){}

    public Connection(@NonNull String fromPlace, @NonNull String toPlace) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
    }

    public Connection(@NonNull String fromPlace, @NonNull String toPlace,
                      Date validFrom, Date validTo) {

        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
