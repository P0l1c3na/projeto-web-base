package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Perfil;
import com.stefanini.model.Pessoa;

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class PerfilDao extends GenericDao<Perfil, Long> {

	public PerfilDao() {
		super(Perfil.class);
	}

}
