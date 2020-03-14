package com.stefanini.resource;

import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PerfilServico;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("perfis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

    @Inject
    private PerfilServico perfilResource;

    @GET
    public Response obterListaPessoa() {
        return Response.ok(perfilResource.getList().get()).build();
    }

    @POST
    public Response obterListaPessoa(@Valid Perfil perfil) {
        return Response.ok(perfilResource.salvar(perfil)).build();
    }

    @DELETE
    @Path("{id}")
    public void deletarPessoa(@PathParam("id") Long id) {
        perfilResource.remover(id);
    }

    @PUT
    public Response atualizarPessoa(@Valid Perfil perfil) {
        return Response.ok(perfilResource.atualizar(perfil)).build();
    }

    @GET
    @Path("{id}")
    public Response obterPessoa(@PathParam("id") Long id) {
        Optional<Perfil> pessoaOptional = perfilResource.encontrar(id);

        if (pessoaOptional.isPresent()) {
            return Response.ok(pessoaOptional.get()).build();
        } else {
            return Response.ok(Optional.empty()).build();
        }
    }

}
