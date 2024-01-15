package org.aquatropical.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Materiel extends PanacheEntity {
    public String nom;
    public double prix;
    public String devise;
    public int quantite;
}
