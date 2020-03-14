package com.stefanini.resource;

<<<<<<< refs/remotes/origin/master
import com.stefanini.dto.SucessoDto;
import com.stefanini.model.Endereco;
=======
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
>>>>>>> Adicionando as classes de serviço e resources
import com.stefanini.servico.EnderecoServico;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
<<<<<<< refs/remotes/origin/master
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
=======
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
>>>>>>> Adicionando as classes de serviço e resources

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

<<<<<<< refs/remotes/origin/master
    private static Logger log = Logger.getLogger(EnderecoResource.class.getName());


    /**
     * Classe de servico da Pessoa
     */
    @Inject
    private EnderecoServico enderecoServico;
    /**
     *
     */
    @Context
    private UriInfo uriInfo;


    /**
     *
     * @return
     */
    @GET
    public Response obterEnderecos() {
        log.info("Obtendo lista de pessoas");

        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        Optional<List<Endereco>> listPessoa = enderecoServico.getList();
        return listPessoa.map(enderecos -> Response.ok(enderecos).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     *
     * @param endereco
     * @return
     */
    @POST
    public Response adicionarEndereco(@Valid Endereco endereco) {
        return Response.ok(enderecoServico.salvar(endereco)).build();
    }


    /**
     *
     * @param endereco
     * @return
     */
    @PUT
    public Response atualizarEndereco(@Valid Endereco endereco) {
        return Response.ok(enderecoServico.atualizar(endereco)).build();
    }


    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    public Response deletarEndereco(@PathParam("id") Long id) {
        if(enderecoServico.encontrar(id).isPresent()){
            enderecoServico.remover(id);
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    public Response obterEndereco(@PathParam("id") Long id) {
        return enderecoServico.encontrar(id).map(endereco -> Response.ok(endereco).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
=======
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
>>>>>>> Adicionando as classes de serviço e resources
    }

}
