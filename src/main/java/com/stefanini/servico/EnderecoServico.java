package com.stefanini.servico;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author joaopedromilhome
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
<<<<<<< refs/remotes/origin/master
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
=======
>>>>>>> Adicionando busca de pessoas por UF
public class EnderecoServico implements Serializable {
	
	@Inject
	private EnderecoDao dao;

<<<<<<< refs/remotes/origin/master

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

=======
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
>>>>>>> Adicionando busca de pessoas por UF
	public Endereco salvar(@Valid Endereco entity) {
		return dao.salvar(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

	public Endereco atualizar(@Valid Endereco entity) {
		return dao.atualizar(entity);
	}

<<<<<<< refs/remotes/origin/master
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)

=======
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
>>>>>>> Adicionando busca de pessoas por UF
	public void remover(Long id) {
	dao.remover(id);
	}

<<<<<<< refs/remotes/origin/master

=======
>>>>>>> Adicionando busca de pessoas por UF
	public Optional<List<Endereco>> getList() {
		return dao.getList();
	}

	public Optional<Endereco> encontrar(Long id) {
		return dao.encontrar(id);
	}
}
