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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author thiag
 */
@Entity
@Table(name = "rodada")
public class Rodada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_rodada")
    private Long codigo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

    @NotNull(message = "Data encerramento é obrigatoria")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_encerramento;

    @Min(value = 1, message = "Valor da aposta é obrigatorio")
    @Column(precision = 7, scale = 2, nullable = false)
    private double preco;

    @Min(value = 1, message = "Valor do prêmio é obrigatorio")
    @Column(precision = 7, scale = 2, nullable = false)
    private double premio;

    @Column(nullable = false)
    private String situacao;
    
    @NotEmpty(message = "O campo time casa do jogo 1 é obrigatorio")
    @Column(name = "jogo1_casa", length = 50, nullable = false)
    private String jogo1Casa;
    
    @NotEmpty(message = "O campo time visitante do jogo 1 é obrigatorio")
    @Column(name = "jogo1_visitante", length = 50, nullable = false)
    private String jogo1Visitante;
    
    @NotNull(message = "Data do jogo 1 é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo1;
    
    @NotEmpty(message = "O campo time casa do jogo 2 é obrigatorio")
    @Column(name = "jogo2_casa", length = 50, nullable = false)
    private String jogo2Casa;
    
    @NotEmpty(message = "O campo time visitante do jogo 2 é obrigatorio")
    @Column(name = "jogo2_visitante", length = 50, nullable = false)
    private String jogo2Visitante;
    
    @NotNull(message = "Data do jogo 2 é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo2;
    
    @NotEmpty(message = "O campo time casa do jogo 3 é obrigatorio")
    @Column(name = "jogo3_casa", length = 50, nullable = false)
    private String jogo3Casa;
    
    @NotEmpty(message = "O campo time visitante do jogo 3 é obrigatorio")
    @Column(name = "jogo3_visitante", length = 50, nullable = false)
    private String jogo3Visitante;
    
    @NotNull(message = "Data do jogo 2 é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo3;
    
    @Column(name = "jogo4_casa", length = 50, nullable = false)
    private String jogo4Casa;
    
    @Column(name = "jogo4_visitante", length = 50, nullable = false)
    private String jogo4Visitante;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataJogo4;

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Date data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.data_criacao);
        hash = 97 * hash + Objects.hashCode(this.data_encerramento);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.premio) ^ (Double.doubleToLongBits(this.premio) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.situacao);
        hash = 97 * hash + Objects.hashCode(this.jogo1Casa);
        hash = 97 * hash + Objects.hashCode(this.jogo1Visitante);
        hash = 97 * hash + Objects.hashCode(this.dataJogo1);
        hash = 97 * hash + Objects.hashCode(this.jogo2Casa);
        hash = 97 * hash + Objects.hashCode(this.jogo2Visitante);
        hash = 97 * hash + Objects.hashCode(this.dataJogo2);
        hash = 97 * hash + Objects.hashCode(this.jogo3Casa);
        hash = 97 * hash + Objects.hashCode(this.jogo3Visitante);
        hash = 97 * hash + Objects.hashCode(this.dataJogo3);
        hash = 97 * hash + Objects.hashCode(this.jogo4Casa);
        hash = 97 * hash + Objects.hashCode(this.jogo4Visitante);
        hash = 97 * hash + Objects.hashCode(this.dataJogo4);
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
        final Rodada other = (Rodada) obj;
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.premio) != Double.doubleToLongBits(other.premio)) {
            return false;
        }
        if (!Objects.equals(this.situacao, other.situacao)) {
            return false;
        }
        if (!Objects.equals(this.jogo1Casa, other.jogo1Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo1Visitante, other.jogo1Visitante)) {
            return false;
        }
        if (!Objects.equals(this.jogo2Casa, other.jogo2Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo2Visitante, other.jogo2Visitante)) {
            return false;
        }
        if (!Objects.equals(this.jogo3Casa, other.jogo3Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo3Visitante, other.jogo3Visitante)) {
            return false;
        }
        if (!Objects.equals(this.jogo4Casa, other.jogo4Casa)) {
            return false;
        }
        if (!Objects.equals(this.jogo4Visitante, other.jogo4Visitante)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.data_criacao, other.data_criacao)) {
            return false;
        }
        if (!Objects.equals(this.data_encerramento, other.data_encerramento)) {
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
        return "Rodada{" + "codigo=" + codigo + ", data_criacao=" + data_criacao + ", data_encerramento=" + data_encerramento + ", preco=" + preco + ", premio=" + premio + ", situacao=" + situacao + ", jogo1Casa=" + jogo1Casa + ", jogo1Visitante=" + jogo1Visitante + ", dataJogo1=" + dataJogo1 + ", jogo2Casa=" + jogo2Casa + ", jogo2Visitante=" + jogo2Visitante + ", dataJogo2=" + dataJogo2 + ", jogo3Casa=" + jogo3Casa + ", jogo3Visitante=" + jogo3Visitante + ", dataJogo3=" + dataJogo3 + ", jogo4Casa=" + jogo4Casa + ", jogo4Visitante=" + jogo4Visitante + ", dataJogo4=" + dataJogo4 + '}';
    }
    

   

}
