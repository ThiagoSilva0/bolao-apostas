/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.ApostaDao;
import br.com.bolao.dao.RodadaDao;
import br.com.bolao.dao.UsuarioDao;
import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Rodada;
import br.com.bolao.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiag
 */
@ManagedBean
@ViewScoped
public class ExtratoCambistaBean {

    private List<Rodada> rodadas = new ArrayList<>();
    
    private Usuario usuario;
    private Rodada rodada;
    
    private Long codigoRodada;
    private String login;
    
    int contAposta = 0;
    double bruto = 0;
    double comissao = 0;
    double liquido = 0;

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

    
    public double getBruto() {
        return bruto;
    }

    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getLiquido() {
        return liquido;
    }

    public void setLiquido(double liquido) {
        this.liquido = liquido;
    }
    
    

    public Long getCodigo() {
        return codigoRodada;
    }

    public void setCodigo(Long codigoRodada) {
        this.codigoRodada = codigoRodada;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<Rodada> rodadas) {
        this.rodadas = rodadas;
    }

    public Long getCodigoRodada() {
        return codigoRodada;
    }

    public void setCodigoRodada(Long codigoRodada) {
        this.codigoRodada = codigoRodada;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getContAposta() {
        return contAposta;
    }

    public void setContAposta(int contAposta) {
        this.contAposta = contAposta;
    }

    @PostConstruct
    public void listarRodadas() {
        RodadaDao rodadaDao = new RodadaDao();
        rodadas = rodadaDao.listar();
    }

    public void extrato(){
                   
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario = usuarioDao.buscarPorLogin(login);

        RodadaDao rodadaDao = new RodadaDao();
        rodada = rodadaDao.buscarPorCodigo(codigoRodada);

        ApostaDao apostaDao = new ApostaDao();
        List<Aposta> apostas = apostaDao.listar();

        List<Aposta> apostasDaRodada = new ArrayList<>();
        
        for (Aposta aposta : apostas) {
            
            if (aposta.getUsuario().getCodigo() == usuario.getCodigo()
                    && aposta.getRodada().getCodigo() == rodada.getCodigo()) {
                
                apostasDaRodada.add(aposta);
                contAposta++;
            }
        }
        bruto = contAposta * rodada.getPreco();
        comissao = ((bruto * 15)/100);
        liquido = bruto - comissao;
       
    }
}
