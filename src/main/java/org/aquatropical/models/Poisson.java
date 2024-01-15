package org.aquatropical.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Poisson extends PanacheEntity {

    public String nom;
    public double prix;
    public int quantite;
}
