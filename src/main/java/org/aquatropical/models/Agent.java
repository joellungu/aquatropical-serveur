package org.aquatropical.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Agent extends PanacheEntity {

    public String nom;
    public String postnom;
    public String prenom;
    public String telephone;
    public String mdp;
    public String role;
    public int roleIndex;
    public String adresse;
    public int status;
}
