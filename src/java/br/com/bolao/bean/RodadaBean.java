/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.RodadaDao;
import br.com.bolao.domain.Rodada;
import br.com.bolao.util.FacesUtil;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiag
 */
@ManagedBean
@ViewScoped
public class RodadaBean {
    
    private Rodada rodada;
    private List<Rodada> listaRodadas;
    private Long codigo;
    private String acao;
    
    
    public Rodada getRodada() {
        return rodada;
    }
    
    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }
    
    public List<Rodada> getListaRodadas() {
        return listaRodadas;
    }
    
    public void setListaRodadas(List<Rodada> listaRodadas) {
        this.listaRodadas = listaRodadas;
    }
    
    public Long getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public String getAcao() {
        return acao;
    }
    
    public void setAcao(String acao) {
        this.acao = acao;
    }
    
    public void atualizarSituacao() {
        RodadaDao rodadaDao = new RodadaDao();
        listaRodadas = rodadaDao.listar();
        for (Rodada listaRodada : listaRodadas) {
            System.out.println(listaRodada.getData_encerramento().compareTo(new Date()));
            if (listaRodada.getData_encerramento().compareTo(new Date()) < 0) {
                
                listaRodada.setSituacao("e");
                rodadaDao.editar(listaRodada);
            }
        }
    }
    
    public void listar() {
        try {
            RodadaDao rodadaDao = new RodadaDao();
            listaRodadas = rodadaDao.listar();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar listar as rodadas! " + e.getMessage());
        }
    }
    
    public void carregarCadastro() {
        
        try {
            if (codigo != null) {
                RodadaDao rodadaDao = new RodadaDao();
                rodada = rodadaDao.buscarPorCodigo(codigo);
            } else {
                rodada = new Rodada();
            }
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar obter dados da rodada! " + e.getMessage());
        }
    }
    
    public void salvar() {
        try {
            rodada.setSituacao("a");
            rodada.setData_criacao(new Date());
            RodadaDao rodadaDao = new RodadaDao();
            System.out.println(rodada.getDataJogo1());
            System.out.println(rodada.getDataJogo2());
            rodadaDao.salvar(rodada);
            FacesUtil.addMsgInfo("Rodada " + rodada.getCodigo() + " cadastrada com sucesso!");
            rodada = new Rodada();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar cadastrar rodada, " + e.getMessage());
        }
    }
    
    public void editar() {
        try {
            RodadaDao rodadaDao = new RodadaDao();
            rodadaDao.editar(rodada);
            FacesUtil.addMsgInfo("Rodada " + rodada.getCodigo() + " editada com sucesso!");
            rodada = new Rodada();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar editar rodada, " + e.getMessage());
        }
    }
    
    public void excluir() {
        try {
            RodadaDao rodadaDao = new RodadaDao();
            rodadaDao.excluir(rodada);
            FacesUtil.addMsgInfo("Rodada " + rodada.getCodigo() + " excluida com sucesso!");
            rodada = new Rodada();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar excluir rodada, " + e.getMessage());
        }
    }
    
    public void novo() {
        rodada = new Rodada();
    }
}
