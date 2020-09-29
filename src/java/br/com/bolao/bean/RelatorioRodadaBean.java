/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.RodadaDao;
import br.com.bolao.domain.Rodada;
import br.com.bolao.relatorio.RelatorioRodada;
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
public class RelatorioRodadaBean {
    
    private Rodada rodada;
    private List<Rodada> rodadas = new ArrayList<>();
    private RodadaDao rodadaDao = new RodadaDao();
    
    @PostConstruct
    public void inicio(){
       rodadas = rodadaDao.listar();
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(List<Rodada> rodadas) {
        this.rodadas = rodadas;
    }

    public RodadaDao getRodadaDao() {
        return rodadaDao;
    }

    public void setRodadaDao(RodadaDao rodadaDao) {
        this.rodadaDao = rodadaDao;
    }
    
    public void imprimir(){
        RelatorioRodada relatorioRodada = new RelatorioRodada();
        System.out.println(relatorioRodada.toString());
        for (Rodada rodada1 : rodadas) {
            System.out.println(rodada1.toString());
        }
        relatorioRodada.getRelatorio(rodadas);
    
    }
}
