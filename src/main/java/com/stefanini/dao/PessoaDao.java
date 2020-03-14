package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;

import javax.persistence.criteria.*;
import java.util.stream.Stream;

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class PessoaDao extends GenericDao<Pessoa, Long> {

	public PessoaDao() {
		super(Pessoa.class);
	}

	public Stream<Pessoa> getPessoasPorUf(String uf){
		CriteriaBuilder cb = this .entityManager.getCriteriaBuilder();
		CriteriaQuery<Pessoa> q = cb.createQuery(Pessoa.class);
		Root<Pessoa> pessoaRoot = q.from(Pessoa.class);
		q.select(pessoaRoot);
		Join<Pessoa, Endereco> join = pessoaRoot.join("enderecos");

		Root<Endereco> enderecoRoot =q.from(Endereco.class);

		ParameterExpression<String> p = cb.parameter(String.class);
		q.where(cb.equal(enderecoRoot.get("uf"), uf));

		System.out.println("QUERY : " + this.entityManager.createQuery(q).toString());

		return this.entityManager.createQuery(q).getResultStream();
	}

}
