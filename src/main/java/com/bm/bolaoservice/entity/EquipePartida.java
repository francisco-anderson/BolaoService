/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Anderson
 */
@Table(name = "EQUIPE_PARTIDA")
@Entity
@NamedQueries({
    @NamedQuery(name = "EquipePartida.findAll", query = "SELECT e FROM EquipePartida e"),
    @NamedQuery(name = "EquipePartida.findByGols", query = "SELECT e FROM EquipePartida e WHERE e.gol = :gols"),
    @NamedQuery(name = "EquipePartida.findByGolsPenalti", query = "SELECT e FROM EquipePartida e WHERE e.golPenalti = :golsPenalti"),
    @NamedQuery(name = "EquipePartida.findByIdEquipe", query = "SELECT e FROM EquipePartida e WHERE e.equipePartidaPK.idEquipe = :idEquipe"),
    @NamedQuery(name = "EquipePartida.findByIdPartida", query = "SELECT e FROM EquipePartida e WHERE e.equipePartidaPK.idPartida = :idPartida")})
public class EquipePartida implements Serializable {

    private static final long serialVersionUID = -3182922397635831126L;

    @EmbeddedId
    protected EquipePartidaPK equipePartidaPK;
    @Column(name = "GOLS")
    private int gol;
    @Column(name = "GOLS_PENALTI")
    private int golPenalti;
    @JoinColumn(name = "ID_EQUIPE", referencedColumnName = "ID_EQUIPE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipe equipe;
    @JoinColumn(name = "ID_PARTIDA", referencedColumnName = "ID_PARTIDA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partida partida;

    public EquipePartida() {
    }

    public EquipePartida(EquipePartidaPK equipePartidaPK) {
        this.equipePartidaPK = equipePartidaPK;
    }

    public EquipePartida(Long idEquipe, Long idPartida) {
        this.equipePartidaPK = new EquipePartidaPK(idEquipe, idPartida);
    }

    public EquipePartidaPK getEquipePartidaPK() {
        return equipePartidaPK;
    }

    public void setEquipePartidaPK(EquipePartidaPK equipePartidaPK) {
        this.equipePartidaPK = equipePartidaPK;
    }

    public int getGol() {
        return gol;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public int getGolPenalti() {
        return golPenalti;
    }

    public void setGolPenalti(int golPenalti) {
        this.golPenalti = golPenalti;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

}
