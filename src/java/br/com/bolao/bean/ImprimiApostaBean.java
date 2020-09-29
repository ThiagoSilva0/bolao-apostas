/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.ApostaDao;
import br.com.bolao.dao.RodadaDao;
import br.com.bolao.domain.Aposta;
import br.com.bolao.relatorio.RelatorioAposta;
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
public class ImprimiApostaBean {

    private List<Aposta> apostas = new ArrayList<>();
    private ApostaDao apostaDao = new ApostaDao();

    @PostConstruct
    public void inicio() {
        apostas = apostaDao.listar();
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    public ApostaDao getApostaDao() {
        return apostaDao;
    }

    public void setApostaDao(ApostaDao apostaDao) {
        this.apostaDao = apostaDao;
    }

    public void imprimir(Aposta aposta) {
        
        List<Aposta> apostaImprimir = new ArrayList<>();
        
        apostas = apostaDao.listar();
        for (Aposta aposta1 : apostas) {
            
            if (aposta1.getRodada().getCodigo() == aposta.getRodada().getCodigo()
                    && aposta1.getNomeCliente().equals(aposta.getNomeCliente())) {
                if (aposta1.getDataAposta().compareTo(aposta.getDataAposta()) == 0) {
            
                    apostaImprimir.add(aposta);
                }

            }
        }
        RelatorioAposta relatorioAposta = new RelatorioAposta();
        relatorioAposta.getRelatorio(apostaImprimir);
    }

}
