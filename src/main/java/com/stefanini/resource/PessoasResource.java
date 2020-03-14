package com.stefanini.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

import java.util.Optional;

@Path("pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoasResource {

    @Inject
    private PessoaServico pessoaServico;

    @GET
    public Response obterListaPessoa() {
        return Response.ok(pessoaServico.getList().get()).build();
    }

    @POST
    public Response obterListaPessoa(@Valid Pessoa pessoa) {
        return Response.ok(pessoaServico.salvar(pessoa)).build();
    }

    @DELETE
    @Path("{id}")
    public void deletarPessoa(@PathParam("id") Long id) {
        pessoaServico.remover(id);
    }

    @PUT
    public Response atualizarPessoa(@Valid Pessoa pessoa) {
        return Response.ok(pessoaServico.atualizar(pessoa)).build();
    }

    @GET
    @Path("{id}")
    public Response obterPessoa(@PathParam("id") Long id) {
        Optional<Pessoa> pessoaOptional = pessoaServico.encontrar(id);

        if (pessoaOptional.isPresent()) {
            return Response.ok(pessoaOptional.get()).build();
        } else {
            return Response.ok(Optional.empty()).build();
        }
    }

}
