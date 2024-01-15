package org.aquatropical.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aquatropical.models.Materiel;
import org.aquatropical.models.Poisson;

import java.util.List;

@Path("materiel")
public class MaterielController {
    //
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Materiel> getTout( ){
        List<Materiel> materiels = Materiel.listAll();
        return materiels;
    }

    //
    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    @Transactional
    public Response enregistrer(Materiel materiel) {
        materiel.persist();
        //
        return Response.ok().build();
    }

    //
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response mettreAjour(Materiel materiel){
        Materiel materiel1 = Materiel.findById(materiel.id);
        if(materiel1 == null){
            return Response.status(404).build();
        }
        //
        materiel1.nom = materiel.nom;
        materiel1.prix = materiel.prix;
        materiel1.devise = materiel.devise;
        materiel1.quantite = materiel.quantite;
        //

        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response supprimer(Long id) {
        Materiel.deleteById(id);
        return Response.ok().build();
    }
}
