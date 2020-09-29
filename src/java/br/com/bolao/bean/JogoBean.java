/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.JogoDao;
import br.com.bolao.dao.RodadaDao;
import br.com.bolao.domain.Jogo;
import br.com.bolao.domain.Rodada;
import br.com.bolao.util.FacesUtil;
import java.util.ArrayList;
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
public class JogoBean {

    private Jogo jogo;
    private Rodada rodada;
    private List<Jogo> listaJogos;
    private List<Jogo> listaJogosPorRodada;

    private Long codigo;
    private Long codigoRodada;
    private String acao;

    public Long getCodigoRodada() {
        return codigoRodada;
    }

    public void setCodigoRodada(Long codigoRodada) {
        this.codigoRodada = codigoRodada;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public List<Jogo> getListaJogosPorRodada() {

        return listaJogosPorRodada;
    }

    public void setListaJogosPorRodada(List<Jogo> listaJogosPorRodada) {
        this.listaJogosPorRodada = listaJogosPorRodada;
    }

    public Jogo getJogo() {

        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public List<Jogo> getListaJogos() {
        return listaJogos;
    }

    public void setListaJogos(List<Jogo> listaJogos) {
        this.listaJogos = listaJogos;
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

    public void listar() {
        try {
            JogoDao jogoDao = new JogoDao();
            listaJogos = jogoDao.listar();

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar listar os Jogos! " + e.getMessage());
        }
    }

    public void carregarRodadaCadastro() {

        try {
            RodadaDao rodadaDao = new RodadaDao();
            rodada = rodadaDao.buscarPorCodigo(codigoRodada);

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar obter dados da rodada! " + e.getMessage());
        }
    }

    public void carregarCadastro() {

        try {
            if (codigo != null) {
                JogoDao jogoDao = new JogoDao();
                jogo = jogoDao.buscarPorCodigo(codigo);
            } else {
                jogo = new Jogo();
            }
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar obter dados djogo! " + e.getMessage());
        }
    }

    public void salvar() {
        try {

            jogo.setRodada(rodada);
            JogoDao jogoDao = new JogoDao();

            jogoDao.salvar(jogo);
            FacesUtil.addMsgInfo("Jogo cadastrado com sucesso!");
            jogo = new Jogo();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar cadastrar jogo, " + e.getMessage());
        }
    }

    public void editar() {
        try {

            JogoDao jogoDao = new JogoDao();

            jogoDao.editar(jogo);
            FacesUtil.addMsgInfo("Jogo editado com sucesso!");
            jogo = new Jogo();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao editar jogo, " + e.getMessage());
        }
    }

    public void excluir() {
        try {

            JogoDao jogoDao = new JogoDao();

            jogoDao.excluir(jogo);
            FacesUtil.addMsgInfo("Jogo excluido com sucesso!");
            jogo = new Jogo();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao excluir jogo, " + e.getMessage());
        }
    }

    public void novo() {
        jogo = new Jogo();
    }

    public List<Jogo> listaPorRodada(Long cod) {
        listaJogosPorRodada = new ArrayList<>();
        for (Jogo jogo : listaJogos) {
            if (jogo.getRodada().getCodigo() == cod) {

                listaJogosPorRodada.add(jogo);
            }
        }

        return listaJogosPorRodada;
    }

    public List<Jogo> jogsDarodada() {
        listaJogosPorRodada = new ArrayList<>();
        for (Jogo listaJogo : listaJogos) {
            if(listaJogo.getRodada().getSituacao().equals("a")){
            listaJogosPorRodada.add(listaJogo);
            }
        }
        return listaJogosPorRodada;
    }

}
