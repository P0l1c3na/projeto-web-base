package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;

<<<<<<< refs/remotes/origin/master
import javax.persistence.TypedQuery;
import java.util.Optional;
=======
import javax.persistence.criteria.*;
import java.util.stream.Stream;
>>>>>>> Adicionando busca de pessoas por UF

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class PessoaDao extends GenericDao<Pessoa, Long> {

	public PessoaDao() {
		super(Pessoa.class);
	}

<<<<<<< refs/remotes/origin/master
	/**
	 * Efetuando busca de Pessoa por email
	 * @param email
	 * @return
	 */
	public Optional<Pessoa> buscarPessoaPorEmail(String email){
		TypedQuery<Pessoa> q2 =
				entityManager.createQuery(" select p from Pessoa p where p.email=:email", Pessoa.class);
		q2.setParameter("email", email);
		return q2.getResultStream().findFirst();
=======
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
>>>>>>> Adicionando busca de pessoas por UF
	}

}
