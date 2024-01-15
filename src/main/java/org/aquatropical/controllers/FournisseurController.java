package org.aquatropical.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aquatropical.models.Agent;
import org.aquatropical.models.Fournisseur;

import java.util.HashMap;
import java.util.List;

@Path("fournisseur")
public class FournisseurController {
    //
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fournisseur> getTout( ){
        List<Fournisseur> fournisseurs = Fournisseur.listAll();
        return fournisseurs;
    }

    //
    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    @Transactional
    public Response enregistrer(Fournisseur fournisseur) {
        fournisseur.persist();
        //
        return Response.ok().build();
    }


    //
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response mettreAjour(Fournisseur fournisseur){
        Fournisseur fournisseur1 = Fournisseur.findById(fournisseur.id);
        if(fournisseur1 == null){
            return Response.status(404).build();
        }
        //
        fournisseur1.nom = fournisseur.nom;
        fournisseur1.postnom = fournisseur.postnom;
        fournisseur1.prenom = fournisseur.prenom;
        fournisseur1.telephone = fournisseur.telephone;
        fournisseur1.email = fournisseur.email;
        fournisseur1.type = fournisseur.type;
        fournisseur1.typeIndex = fournisseur.typeIndex;
        fournisseur1.adresse = fournisseur.adresse;
        fournisseur1.status = fournisseur.status;
        //

        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response supprimer(Long id) {
        Fournisseur.deleteById(id);
        return Response.ok().build();
    }
}
