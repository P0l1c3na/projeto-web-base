package com.stefanini.servico;

import com.stefanini.dao.PerfilDao;
<<<<<<< refs/remotes/origin/master
import com.stefanini.dao.PerfilDao;
import com.stefanini.exception.NegocioException;
import com.stefanini.model.Perfil;
=======
import com.stefanini.dao.PessoaDao;
>>>>>>> Adicionando as classes de serviço e resources
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * 
 * @author joaopedromilhome
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
<<<<<<< refs/remotes/origin/master
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerfilServico implements Serializable {


=======
public class PerfilServico implements Serializable {

>>>>>>> Adicionando as classes de serviço e resources
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< refs/remotes/origin/master

	@Inject
	private PerfilDao dao;

	@Inject
	private PessoaPerfilServico pessoaPerfilServico;

	/**
	 * Salvar os dados de uma Perfil
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Perfil salvar(@Valid Perfil perfil) {
		return dao.salvar(perfil);
	}


	/**
	 * Validando se existe pessoa com email
	 */
	public Boolean validarPerfil(@Valid Perfil perfil){
		Optional<Perfil> perfil1 = dao.buscarPessoaPorNome(perfil.getNome());
		return perfil1.isEmpty();
	}

	/**
	 * Atualizar o dados de uma perfil
=======
	@Inject
	private PerfilDao dao;
	/**
	 * Salvar os dados de uma Pessoa
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Perfil salvar(@Valid Perfil perfil) {
		System.out.println(perfil);
		return dao.salvar(perfil);
	}

	/**
	 * Atualizar o dados de uma pessoa
>>>>>>> Adicionando as classes de serviço e resources
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Perfil atualizar(@Valid Perfil entity) {
		return dao.atualizar(entity);
	}

	/**
<<<<<<< refs/remotes/origin/master
	 * Remover uma perfil pelo id
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void remover(@Valid Long id) throws NegocioException {
		if(pessoaPerfilServico.buscarPessoaPerfil(null,id).count() == 0){
			dao.remover(id);
			return;
		}
		throw new NegocioException("Não foi possivel remover o perfil");
	}

	/**
	 * Buscar uma lista de Perfil
	 */
=======
	 * Remover uma pessoa pelo id
	 */
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void remover(@Valid Long id) {
		dao.remover(id);
	}

	/**
	 * Buscar uma lista de Pessoa
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
>>>>>>> Adicionando as classes de serviço e resources
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}

	/**
<<<<<<< refs/remotes/origin/master
	 * Buscar uma Perfil pelo ID
	 */
//	@Override
=======
	 * Buscar uma Pessoa pelo ID
	 */
>>>>>>> Adicionando as classes de serviço e resources
	public Optional<Perfil> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
