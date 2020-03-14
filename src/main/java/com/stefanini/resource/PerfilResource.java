package com.stefanini.resource;

<<<<<<< refs/remotes/origin/master
import com.stefanini.dto.ErroDto;
import com.stefanini.dto.SucessoDto;
import com.stefanini.exception.NegocioException;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PerfilServico;
import com.stefanini.servico.PessoaServico;
=======
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PerfilServico;
>>>>>>> Adicionando as classes de serviço e resources

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
<<<<<<< refs/remotes/origin/master
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Path("perfils")
=======
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("perfis")
>>>>>>> Adicionando as classes de serviço e resources
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerfilResource {

<<<<<<< refs/remotes/origin/master
    private static Logger log = Logger.getLogger(PerfilResource.class.getName());


    /**
     * Classe de servico da Pessoa
     */
    @Inject
    private PerfilServico perfilServico;
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
    public Response obterPerfils() {
        log.info("Obtendo lista de perfils");
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        Optional<List<Perfil>> listPessoa = perfilServico.getList();
        return listPessoa.map(perfils -> Response.ok(perfils).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     *
     * @param perfil
     * @return
     */
    @POST
    public Response adicionarPerfil(@Valid Perfil perfil) {
        log.info("Adicionando perfils");
        if(perfilServico.validarPerfil(perfil)){
            return Response.ok(perfilServico.salvar(perfil)).build();
        }
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(new ErroDto("nome","nome do perfil já existe", perfil.getNome())).build();
    }


    /**
     *
     * @param perfil
     * @return
     */
    @PUT
    public Response atualizarPerfil(@Valid Perfil perfil) {
        log.info("Atualizando perfil");
        return Response.ok(perfilServico.atualizar(perfil)).build();
    }


    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    public Response deletarPerfil(@PathParam("id") Long id) {
        log.info("Deletando perfil");
        try{
            if(perfilServico.encontrar(id).isPresent()){
                perfilServico.remover(id);
                return Response.status(Response.Status.OK).build();
            }else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (NegocioException e) {
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(new ErroDto(null,e.getMensagem(),id)).build();
        }

    }


    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    public Response obterPerfil(@PathParam("id") Long id) {
        return perfilServico.encontrar(id).map(perfil -> Response.ok(perfil).build()).orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
=======
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
>>>>>>> Adicionando as classes de serviço e resources
    }

}
