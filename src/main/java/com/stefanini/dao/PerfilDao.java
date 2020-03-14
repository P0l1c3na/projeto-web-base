package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;

<<<<<<< refs/remotes/origin/master
import javax.persistence.TypedQuery;
import java.util.Optional;

=======
>>>>>>> Adicionando as classes de serviço e resources
/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class PerfilDao extends GenericDao<Perfil, Long> {

	public PerfilDao() {
		super(Perfil.class);
	}

<<<<<<< refs/remotes/origin/master
	/**
	 * Efetuando busca de Pessoa por email
	 * @param nome
	 * @return
	 */
	public Optional<Perfil> buscarPessoaPorNome(String nome){
		TypedQuery<Perfil> q2 =
				entityManager.createQuery(" select p from Perfil p where p.nome=:nome", Perfil.class);
		q2.setParameter("nome", nome);
		return q2.getResultStream().findFirst();
	}

=======
>>>>>>> Adicionando as classes de serviço e resources
}
