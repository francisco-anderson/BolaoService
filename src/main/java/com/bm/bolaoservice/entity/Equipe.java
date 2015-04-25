/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 220460
 */
@XmlRootElement
@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "EQUIPE_SEQ", sequenceName = "EQUIPE_SEQ")
@NamedQueries({
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdEquipe", query = "SELECT e FROM Equipe e WHERE e.id = :idEquipe"),
    @NamedQuery(name = "Equipe.findByNome", query = "SELECT e FROM Equipe e WHERE e.nome = :nome")})
public class Equipe implements AbstractEntity {

    private static final long serialVersionUID = -5667197242867752204L;

    @Id
    @GeneratedValue(generator = "EQUIPE_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_EQUIPE")
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "equipe")    
    private List<EquipePartida> equipePartidaList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "equipe")    
    private List<ApostaEquipePartida> apostaEquipePartidaList;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "equipe")    
    private List<PontuacaoEquipe> pontuacaoEquipeList;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO") 
    private Usuario usuario;

    @Override
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

    public List<EquipePartida> getEquipePartidaList() {
        return equipePartidaList;
    }

    public void setEquipePartidaList(List<EquipePartida> equipePartidaList) {
        this.equipePartidaList = equipePartidaList;
    }

    public List<ApostaEquipePartida> getApostaEquipePartidaList() {
        return apostaEquipePartidaList;
    }

    public void setApostaEquipePartidaList(List<ApostaEquipePartida> apostaEquipePartidaList) {
        this.apostaEquipePartidaList = apostaEquipePartidaList;
    }

    public List<PontuacaoEquipe> getPontuacaoEquipeList() {
        return pontuacaoEquipeList;
    }

    public void setPontuacaoEquipeList(List<PontuacaoEquipe> pontuacaoEquipeList) {
        this.pontuacaoEquipeList = pontuacaoEquipeList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
