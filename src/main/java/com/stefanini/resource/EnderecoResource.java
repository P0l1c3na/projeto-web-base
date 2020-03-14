package com.stefanini.resource;

import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    private EnderecoServico enderecoServico;

    @GET
    public Response obterListaPessoa() {
        return Response.ok(enderecoServico.getList().get()).build();
    }

    @POST
    public Response obterListaPessoa(@Valid Endereco endereco) {
        return Response.ok(enderecoServico.salvar(endereco)).build();
    }

    @DELETE
    @Path("{id}")
    public void deletarPessoa(@PathParam("id") Long id) {
        enderecoServico.remover(id);
    }

    @PUT
    public Response atualizarPessoa(@Valid Endereco endereco) {
        return Response.ok(enderecoServico.atualizar(endereco)).build();
    }

    @GET
    @Path("{id}")
    public Response obterPessoa(@PathParam("id") Long id) {
        Optional<Endereco> pessoaOptional = enderecoServico.encontrar(id);

        if (pessoaOptional.isPresent()) {
            return Response.ok(pessoaOptional.get()).build();
        } else {
            return Response.ok(Optional.empty()).build();
        }
    }

}
