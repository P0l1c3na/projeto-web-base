package com.stefanini.servico;

import com.stefanini.dao.PerfilDao;
import com.stefanini.dao.PessoaDao;
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
public class PerfilServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Perfil atualizar(@Valid Perfil entity) {
		return dao.atualizar(entity);
	}

	/**
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
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}

	/**
	 * Buscar uma Pessoa pelo ID
	 */
	public Optional<Perfil> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
