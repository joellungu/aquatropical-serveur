package org.aquatropical.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;

import java.util.HashMap;

@Entity
public class Rapport extends PanacheEntity {
    //
    public String date;
    public String heure;
    @Lob
    public String rapports;
    //
}
