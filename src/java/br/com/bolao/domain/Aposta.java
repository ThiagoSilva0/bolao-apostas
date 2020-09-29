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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author thiag
 */
@Entity
@Table(name = "Aposta")
public class Aposta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_aposta")
    private Long codigo;

    @Column(length = 50, nullable = false)
    private String nomeCliente;

    @Column(length = 50, nullable = false)
    private String telefoneCliente;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataAposta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_cod_usuario", referencedColumnName = "cod_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rodada_cod_rodada", referencedColumnName = "cod_rodada")
    private Rodada rodada;

    @Column(name = "jogo1_casa", length = 50, nullable = false)
    private String jogo1Casa;

    @Column(name = "jogo1_visitante", length = 50, nullable = false)
    private String jogo1Visitante;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo1;

    @NotNull(message = "Gol do time casa, do jogo 1, é obrigatório")
    @Column(length = 2)
    private String golCasa1;

    @NotNull(message = "Gol do time visitante, do jogo 1, é obrigatório")
    @Column(length = 2)
    private String golVisitante1;

    @Column(name = "jogo2_casa", length = 50, nullable = false)
    private String jogo2Casa;

    @Column(name = "jogo2_visitante", length = 50, nullable = false)
    private String jogo2Visitante;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo2;

    @NotNull(message = "Gol do time casa, do jogo 2, é obrigatório")
    @Column(length = 2)
    private String golCasa2;

    @NotNull(message = "Gol do time visitante, do jogo 2, é obrigatório")
    @Column(length = 2)
    private String golVisitante2;

    @Column(name = "jogo3_casa", length = 50, nullable = false)
    private String jogo3Casa;

    @Column(name = "jogo3_visitante", length = 50, nullable = false)
    private String jogo3Visitante;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo3;

    @NotNull(message = "Gol do time casa, do jogo 3, é obrigatório")
    @Column(length = 2)
    private String golCasa3;

    @NotNull(message = "Gol do time visitante, do jogo 3, é obrigatório")
    @Column(length = 2)
    private String golVisitante3;

    @Column(name = "jogo4_casa", length = 50, nullable = false)
    private String jogo4Casa;

    @Column(name = "jogo4_visitante", length = 50, nullable = false)
    private String jogo4Visitante;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo4;

    @Column(length = 2)
    private String golCasa4;

    @Column(length = 2)
    private String golVisitante4;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Date getDataAposta() {
        return dataAposta;
    }

    public void setDataAposta(Date dataAposta) {
        this.dataAposta = dataAposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public String getJogo1Casa() {
        return jogo1Casa;
    }

    public void setJogo1Casa(String jogo1Casa) {
        this.jogo1Casa = jogo1Casa;
    }

    public String getJogo1Visitante() {
        return jogo1Visitante;
    }

    public void setJogo1Visitante(String jogo1Visitante) {
        this.jogo1Visitante = jogo1Visitante;
    }

    public Date getDataJogo1() {
        return dataJogo1;
    }

    public void setDataJogo1(Date dataJogo1) {
        this.dataJogo1 = dataJogo1;
    }

    public String getGolCasa1() {
        return golCasa1;
    }

    public void setGolCasa1(String golCasa1) {
        this.golCasa1 = golCasa1;
    }

    public String getGolVisitante1() {
        return golVisitante1;
    }

    public void setGolVisitante1(String golVisitante1) {
        this.golVisitante1 = golVisitante1;
    }

    public String getJogo2Casa() {
        return jogo2Casa;
    }

    public void setJogo2Casa(String jogo2Casa) {
        this.jogo2Casa = jogo2Casa;
    }

    public String getJogo2Visitante() {
        return jogo2Visitante;
    }

    public void setJogo2Visitante(String jogo2Visitante) {
        this.jogo2Visitante = jogo2Visitante;
    }

    public Date getDataJogo2() {
        return dataJogo2;
    }

    public void setDataJogo2(Date dataJogo2) {
        this.dataJogo2 = dataJogo2;
    }

    public String getGolCasa2() {
        return golCasa2;
    }

    public void setGolCasa2(String golCasa2) {
        this.golCasa2 = golCasa2;
    }

    public String getGolVisitante2() {
        return golVisitante2;
    }

    public void setGolVisitante2(String golVisitante2) {
        this.golVisitante2 = golVisitante2;
    }

    public String getJogo3Casa() {
        return jogo3Casa;
    }

    public void setJogo3Casa(String jogo3Casa) {
        this.jogo3Casa = jogo3Casa;
    }

    public String getJogo3Visitante() {
        return jogo3Visitante;
    }

    public void setJogo3Visitante(String jogo3Visitante) {
        this.jogo3Visitante = jogo3Visitante;
    }

    public Date getDataJogo3() {
        return dataJogo3;
    }

    public void setDataJogo3(Date dataJogo3) {
        this.dataJogo3 = dataJogo3;
    }

    public String getGolCasa3() {
        return golCasa3;
    }

    public void setGolCasa3(String golCasa3) {
        this.golCasa3 = golCasa3;
    }

    public String getGolVisitante3() {
        return golVisitante3;
    }

    public void setGolVisitante3(String golVisitante3) {
        this.golVisitante3 = golVisitante3;
    }

    public String getJogo4Casa() {
        return jogo4Casa;
    }

    public void setJogo4Casa(String jogo4Casa) {
        this.jogo4Casa = jogo4Casa;
    }

    public String getJogo4Visitante() {
        return jogo4Visitante;
    }

    public void setJogo4Visitante(String jogo4Visitante) {
        this.jogo4Visitante = jogo4Visitante;
    }

    public Date getDataJogo4() {
        return dataJogo4;
    }

    public void setDataJogo4(Date dataJogo4) {
        this.dataJogo4 = dataJogo4;
    }

    public String getGolCasa4() {
        return golCasa4;
    }

    public void setGolCasa4(String golCasa4) {
        this.golCasa4 = golCasa4;
    }

    public String getGolVisitante4() {
        return golVisitante4;
    }

    public void setGolVisitante4(String golVisitante4) {
        this.golVisitante4 = golVisitante4;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.nomeCliente);
        hash = 47 * hash + Objects.hashCode(this.telefoneCliente);
        hash = 47 * hash + Objects.hashCode(this.dataAposta);
        hash = 47 * hash + Objects.hashCode(this.usuario);
        hash = 47 * hash + Objects.hashCode(this.rodada);
        hash = 47 * hash + Objects.hashCode(this.jogo1Casa);
        hash = 47 * hash + Objects.hashCode(this.jogo1Visitante);
        hash = 47 * hash + Objects.hashCode(this.dataJogo1);
        hash = 47 * hash + Objects.hashCode(this.golCasa1);
        hash = 47 * hash + Objects.hashCode(this.golVisitante1);
        hash = 47 * hash + Objects.hashCode(this.jogo2Casa);
        hash = 47 * hash + Objects.hashCode(this.jogo2Visitante);
        hash = 47 * hash + Objects.hashCode(this.dataJogo2);
        hash = 47 * hash + Objects.hashCode(this.golCasa2);
        hash = 47 * hash + Objects.hashCode(this.golVisitante2);
        hash = 47 * hash + Objects.hashCode(this.jogo3Casa);
        hash = 47 * hash + Objects.hashCode(this.jogo3Visitante);
        hash = 47 * hash + Objects.hashCode(this.dataJogo3);
        hash = 47 * hash + Objects.hashCode(this.golCasa3);
        hash = 47 * hash + Objects.hashCode(this.golVisitante3);
        hash = 47 * hash + Objects.hashCode(this.jogo4Casa);
        hash = 47 * hash + Objects.hashCode(this.jogo4Visitante);
        hash = 47 * hash + Objects.hashCode(this.dataJogo4);
        hash = 47 * hash + Objects.hashCode(this.golCasa4);
        hash = 47 * hash + Objects.hashCode(this.golVisitante4);
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
        final Aposta other = (Aposta) obj;
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCliente, other.telefoneCliente)) {
            return false;
        }
        if (!Objects.equals(this.jogo1Casa, other.jogo1Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo1Visitante, other.jogo1Visitante)) {
            return false;
        }
        if (!Objects.equals(this.golCasa1, other.golCasa1)) {
            return false;
        }
        if (!Objects.equals(this.golVisitante1, other.golVisitante1)) {
            return false;
        }
        if (!Objects.equals(this.jogo2Casa, other.jogo2Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo2Visitante, other.jogo2Visitante)) {
            return false;
        }
        if (!Objects.equals(this.golCasa2, other.golCasa2)) {
            return false;
        }
        if (!Objects.equals(this.golVisitante2, other.golVisitante2)) {
            return false;
        }
        if (!Objects.equals(this.jogo3Casa, other.jogo3Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo3Visitante, other.jogo3Visitante)) {
            return false;
        }
        if (!Objects.equals(this.golCasa3, other.golCasa3)) {
            return false;
        }
        if (!Objects.equals(this.golVisitante3, other.golVisitante3)) {
            return false;
        }
        if (!Objects.equals(this.jogo4Casa, other.jogo4Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo4Visitante, other.jogo4Visitante)) {
            return false;
        }
        if (!Objects.equals(this.golCasa4, other.golCasa4)) {
            return false;
        }
        if (!Objects.equals(this.golVisitante4, other.golVisitante4)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.dataAposta, other.dataAposta)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.rodada, other.rodada)) {
            return false;
        }
        if (!Objects.equals(this.dataJogo1, other.dataJogo1)) {
            return false;
        }
        if (!Objects.equals(this.dataJogo2, other.dataJogo2)) {
            return false;
        }
        if (!Objects.equals(this.dataJogo3, other.dataJogo3)) {
            return false;
        }
        if (!Objects.equals(this.dataJogo4, other.dataJogo4)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aposta{" + "codigo=" + codigo + ", nomeCliente=" + nomeCliente + ", telefoneCliente=" + telefoneCliente + ", dataAposta=" + dataAposta + ", usuario=" + usuario + ", rodada=" + rodada + ", jogo1Casa=" + jogo1Casa + ", jogo1Visitante=" + jogo1Visitante + ", dataJogo1=" + dataJogo1 + ", golCasa1=" + golCasa1 + ", golVisitante1=" + golVisitante1 + ", jogo2Casa=" + jogo2Casa + ", jogo2Visitante=" + jogo2Visitante + ", dataJogo2=" + dataJogo2 + ", golCasa2=" + golCasa2 + ", golVisitante2=" + golVisitante2 + ", jogo3Casa=" + jogo3Casa + ", jogo3Visitante=" + jogo3Visitante + ", dataJogo3=" + dataJogo3 + ", golCasa3=" + golCasa3 + ", golVisitante3=" + golVisitante3 + ", jogo4Casa=" + jogo4Casa + ", jogo4Visitante=" + jogo4Visitante + ", dataJogo4=" + dataJogo4 + ", golCasa4=" + golCasa4 + ", golVisitante4=" + golVisitante4 + '}';
    }

   

}
