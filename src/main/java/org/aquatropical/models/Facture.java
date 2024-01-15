package org.aquatropical.models;

import jakarta.persistence.Lob;

import java.util.HashMap;

public class Facture {
    public Long idAgent;
    public String date;
    public String heure;
    @Lob
    public String contenu;
}
