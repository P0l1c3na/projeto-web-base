package com.stefanini.resource;

import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("pessoas/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoasEnderecosResource {

    @Inject
    private PessoaServico pessoaServico;

    @GET
    @Path("{uf}")
    public Response obterPessoa(@PathParam("uf") String uf) {
        List<Pessoa> pessoas = pessoaServico.getPessoasPorUf(uf);

        if (!pessoas.isEmpty()) {
            return Response.ok(pessoas).build();
        } else {
            return Response.ok(Collections.EMPTY_LIST).build();
        }
    }

}
