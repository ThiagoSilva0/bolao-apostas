/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thiag
 */

public class Jogo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_jogo")
    private Long codigo;

    @Column(name = "time_casa", length = 50, nullable = false)
    private String timeCasa;
    
    @Column(name = "time_visitante", length = 50, nullable = false)
    private String timeVisitante;

    @Column
    private int golCasa;

    @Column
    private int golVisitante;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataJogo;
    
    @ManyToOne
    @JoinColumn(name = "rodada_cod_rodada", referencedColumnName = "cod_rodada",nullable = false)
    private Rodada rodada;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

  
    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public Date getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(Date dataJogo) {
        this.dataJogo = dataJogo;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.timeCasa);
        hash = 23 * hash + Objects.hashCode(this.timeVisitante);
        hash = 23 * hash + this.golCasa;
        hash = 23 * hash + this.golVisitante;
        hash = 23 * hash + Objects.hashCode(this.dataJogo);
        hash = 23 * hash + Objects.hashCode(this.rodada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jogo other = (Jogo) obj;
        if (this.golCasa != other.golCasa) {
            return false;
        }
        if (this.golVisitante != other.golVisitante) {
            return false;
        }
        if (!Objects.equals(this.timeCasa, other.timeCasa)) {
            return false;
        }
        if (!Objects.equals(this.timeVisitante, other.timeVisitante)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.dataJogo, other.dataJogo)) {
            return false;
        }
        if (!Objects.equals(this.rodada, other.rodada)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jogo{" + "codigo=" + codigo + ", timeCasa=" + timeCasa + ", timeVisitante=" + timeVisitante + ", golCasa=" + golCasa + ", golVisitante=" + golVisitante + ", dataJogo=" + dataJogo + ", rodada=" + rodada + '}';
    }

    
}
