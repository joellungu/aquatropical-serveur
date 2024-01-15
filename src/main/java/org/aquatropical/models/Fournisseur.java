package org.aquatropical.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Fournisseur extends PanacheEntity {
    public String nom;
    public String postnom;
    public String prenom;
    public String adresse;
    public String telephone;
    public String email;
    public String type;
    public int typeIndex;
    public int status;

}
