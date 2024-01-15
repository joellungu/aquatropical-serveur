package org.aquatropical.controllers;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.aquatropical.models.Agent;
import org.aquatropical.models.Poisson;

import java.util.HashMap;
import java.util.List;

@Path("agent")
public class AgentController {
    //
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Agent> getTout( ){
        List<Agent> agents = Agent.listAll();
        return agents;
    }

    //
    @POST
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.WILDCARD)
    @Transactional
    public Response enregistrer(Agent agent) {
        agent.persist();
        //
        return Response.ok().build();
    }

    //
    @GET
    @Path("login/{telephone}/{mdp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("telephone") String telephone, @PathParam("mdp") String mdp) {
        //
        HashMap params = new HashMap<>();
        params.put("telephone",telephone);
        params.put("mdp",mdp);

        Agent agent = (Agent) Agent.find("telephone =: telephone and mdp =: mdp",params).firstResult();
        //
        if(agent == null){
            return Response.status(404).build();
        }
        //
        return Response.ok(agent).build();
    }

    //
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response mettreAjour(Agent agent){
        Agent agent1 = Agent.findById(agent.id);
        if(agent1 == null){
            return Response.status(404).build();
        }
        //
        agent1.nom = agent.nom;
        agent1.postnom = agent.postnom;
        agent1.prenom = agent.prenom;
        agent1.telephone = agent.telephone;
        agent1.role = agent.role;
        agent1.roleIndex = agent.roleIndex;
        agent1.adresse = agent.adresse;
        agent1.status = agent.status;
        agent1.mdp = agent.mdp;
        //

        return Response.ok().build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response supprimer(Long id) {
        Agent.deleteById(id);
        return Response.ok().build();
    }
}
