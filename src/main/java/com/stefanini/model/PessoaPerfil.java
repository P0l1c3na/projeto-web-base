package com.stefanini.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PESSOA_PERFIL")
public class PessoaPerfil implements Serializable {

    @Id
    @Column(name = "CO_SEQ_PESSOAL_PERFIL")
    private Long id;

<<<<<<< refs/remotes/origin/master
    @Column(name = "co_seq_perfil",insertable = false,updatable = false)
    private Long idPerfil;
    @Column(name = "co_seq_pessoa",insertable = false,updatable = false)
    private Long idPessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_seq_perfil", referencedColumnName = "co_seq_perfil", nullable = false)
    private Perfil perfil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_seq_pessoa", referencedColumnName = "co_seq_pessoa", nullable = false)
=======
    @ManyToOne
    @JoinColumn(name = "CO_SEQ_PERFIL", referencedColumnName = "CO_SEQ_PERFIL", nullable = false)
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "CO_SEQ_PESSOA", referencedColumnName = "CO_SEQ_PESSOA", nullable = false)
>>>>>>> Alterações nos tipos de transação da classe de serviço da pessoa.
    private Pessoa pessoa;

    public PessoaPerfil() {
		// TODO Auto-generated constructor stub
	}

    public PessoaPerfil(Perfil perfil, Pessoa pessoa) {
        this.perfil = perfil;
        this.pessoa = pessoa;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
