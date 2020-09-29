/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author thiag
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod_usuario")
    private Long codigo;

    @NotEmpty(message = "O campo nome é obrigatorio")
    @Column(name = "nome_usuario",length = 50, nullable = false)
    private String nome;

    @CPF(message = "O campo CPF é obrigatorio")
    @Column(length = 14, unique = true, nullable = false)
    private String cpf;

    @NotEmpty(message = "O campo telefone é obrigatorio")
    @Column(length = 50, nullable = false)
    private String telefone;

    @NotEmpty(message = "O campo Endereço é obrigatorio")
    @Column(length = 50, nullable = false)
    private String endereco;

    @NotEmpty(message = "O campo senha é obrigatorio")
    @Column(length = 32, nullable = false)
    private String senha;
    
    @NotEmpty(message = "O campo login é obrigatorio")
    @Column(length = 32, nullable = false)
    private String login;
    
    @NotEmpty
    (message = "O campo função é obrigatorio")
    @Column(length = 50, nullable = false)
    private String funcao;
    
    @Column(precision = 7, scale = 2, nullable = false)
    private double limite;
    
    @Column(precision = 7, scale = 2, nullable = false)
    private double valorApagar;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(double valorApagar) {
        this.valorApagar = valorApagar;
    }
    
    @Column
    private int qntJogos;
   

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getQntJogos() {
        return qntJogos;
    }

    public void setQntJogos(int qntJogos) {
        this.qntJogos = qntJogos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.codigo);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.cpf);
        hash = 29 * hash + Objects.hashCode(this.telefone);
        hash = 29 * hash + Objects.hashCode(this.endereco);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.funcao);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.limite) ^ (Double.doubleToLongBits(this.limite) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorApagar) ^ (Double.doubleToLongBits(this.valorApagar) >>> 32));
        hash = 29 * hash + this.qntJogos;
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
        final Usuario other = (Usuario) obj;
        if (Double.doubleToLongBits(this.limite) != Double.doubleToLongBits(other.limite)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorApagar) != Double.doubleToLongBits(other.valorApagar)) {
            return false;
        }
        if (this.qntJogos != other.qntJogos) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + ", senha=" + senha + ", funcao=" + funcao + ", qntJogos=" + qntJogos + '}';
    }

    

   

}
