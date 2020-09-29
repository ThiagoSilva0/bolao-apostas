/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.ApostaDao;
import br.com.bolao.dao.RodadaDao;
import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Rodada;
import br.com.bolao.relatorio.RelatorioAposta;
import br.com.bolao.util.FacesUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiag
 */
@ManagedBean
@ViewScoped
public class ConsultaApostaBean {

    private Aposta aposta;
    private Rodada rodada;
    private long coigoAposta;

    public Aposta getAposta() {

        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public long getCoigoAposta() {
        return coigoAposta;
    }

    public void setCoigoAposta(long coigoAposta) {
        this.coigoAposta = coigoAposta;
    }

    public void buscarAposta() {
        try {

            ApostaDao apostaDao = new ApostaDao();
            aposta = apostaDao.buscarPorCodigo(coigoAposta);

            System.out.println(coigoAposta);
            RodadaDao rodadaDao = new RodadaDao();
            rodada = rodadaDao.buscarPorCodigo(aposta.getRodada().getCodigo());
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar buscar aposta " + e.getMessage());
        }
    }
    
    public void imprimir(){
        List<Aposta> apostas = new ArrayList<>();
        apostas.add(aposta);
        RelatorioAposta relatorioAposta = new RelatorioAposta();
        relatorioAposta.getRelatorio(apostas);
    }

    public void limpar() {
        aposta = new Aposta();
    }
}
