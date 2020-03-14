package com.stefanini.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_PERFIL")
    private Long id;
    /**
     *
     */
    @NotNull
    @Column(name = "NO_PERFIL")
    private String nome;
    /**
     *
     */
    @NotNull
    @Column(name = "DS_PERFIL")
    private String descricao;
    /**
     *
     */
    @Column(name = "DT_HORA_INCLUSAO")
    @NotNull
    private LocalDateTime dataHoraInclusao;
    /**
     *
     */
    @Column(name = "DT_HORA_ALTERACAO")
    private LocalDateTime dataHoraAlteracao;

//    @ManyToMany(
//            targetEntity = Pessoa.class,
//            mappedBy = "perfils",
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY
//    )
//    private Set<Pessoa> pessoa;

    public Perfil() {
    }

    public Perfil(@NotNull String nome, @NotNull String descricao, @NotNull LocalDateTime dataHoraInclusao, LocalDateTime dataHoraAlteracao, Set<Pessoa> pessoas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataHoraInclusao = dataHoraInclusao;
        this.dataHoraAlteracao = dataHoraAlteracao;
        //this.pessoa = pessoas;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

//    public Set<Pessoa> getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Set<Pessoa> pessoa) {
//        this.pessoa = pessoa;
//    }

    @Override
    public String toString() {
        return "Perfil{" +
                "  id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataHoraInclusao=" + dataHoraInclusao +
                ", dataHoraAlteracao=" + dataHoraAlteracao +
                '}';
    }
}
