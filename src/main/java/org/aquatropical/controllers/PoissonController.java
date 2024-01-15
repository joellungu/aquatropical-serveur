package org.aquatropical.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aquatropical.models.Poisson;

import java.util.List;

@Path("poisson")
public class PoissonController {
    //
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Poisson> getTout( ){
        List<Poisson> poissons = Poisson.listAll();
        return poissons;
    }

    //
    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    @Transactional
    public Response enregistrer(Poisson poisson) {
        poisson.persist();
        //System.out.println("Poisson: "+poisson);
        //
        return Response.ok().build();
    }

    //
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response mettreAjour(Poisson poisson){
        Poisson poisson1 = Poisson.findById(poisson.id);
        if(poisson1 == null){
            return Response.status(404).build();
        }
        //
        poisson1.nom = poisson.nom;
        poisson1.prix = poisson.prix;
        poisson1.quantite = poisson.quantite;
        //

        return Response.ok().build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response supprimer(Long id) {
        Poisson.deleteById(id);
        return Response.ok().build();
    }
}
