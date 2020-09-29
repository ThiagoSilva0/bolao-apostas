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
import br.com.bolao.relatorio.RelatorioAposta;

import br.com.bolao.util.FacesUtil;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author thiag
 */
@ManagedBean
@ViewScoped
public class ApostaBean {

    private Aposta aposta;
    private Rodada rodada;

    private List<Aposta> apostas = new ArrayList<>();
    private ApostaDao apDao = new ApostaDao();

    private Long codigo;

    private String acao;

    @ManagedProperty(value = "#{autenticacaoBean}")
    private AutenticacaoBean autenticacaoBean;

//    @PostConstruct
//    public void inicio() {
//        apostas = apDao.listar();
//    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }

    public ApostaDao getApostaDao() {
        return apDao;
    }

    public void setApostaDao(ApostaDao apostaDao) {
        this.apDao = apostaDao;
    }

    public AutenticacaoBean getAutenticacaoBean() {
        return autenticacaoBean;
    }

    public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
        this.autenticacaoBean = autenticacaoBean;
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

    public void salvar() {
        try {

            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.buscarPorCodigo(autenticacaoBean.getUsuarioLogado().getCodigo());

            usuario.setQntJogos(usuario.getQntJogos() + 1);

            usuarioDao.editar(usuario);

            aposta.setUsuario(usuario);
            aposta.setRodada(rodada);

            aposta.setJogo1Casa(rodada.getJogo1Casa());
            aposta.setJogo1Visitante(rodada.getJogo1Visitante());
            aposta.setDataJogo1(rodada.getDataJogo1());

            aposta.setJogo2Casa(rodada.getJogo2Casa());
            aposta.setJogo2Visitante(rodada.getJogo2Visitante());
            aposta.setDataJogo2(rodada.getDataJogo2());

            aposta.setJogo3Casa(rodada.getJogo3Casa());
            aposta.setJogo3Visitante(rodada.getJogo3Visitante());
            aposta.setDataJogo3(rodada.getDataJogo3());

            aposta.setJogo4Casa(rodada.getJogo4Casa());
            aposta.setJogo4Visitante(rodada.getJogo4Visitante());
            aposta.setDataJogo4(rodada.getDataJogo4());

            aposta.setDataAposta(new Date());

            ApostaDao apostaDao = new ApostaDao();

            apostaDao.salvar(aposta);

            FacesUtil.addMsgInfo("Aposta feita com sucesso");

            List<Aposta> apostaImprimir = new ArrayList<>();
            apostaImprimir.add(aposta);
            RelatorioAposta relatorioAposta = new RelatorioAposta();
            System.out.println("Chamou relatorio aposta");
            relatorioAposta.getRelatorio(apostaImprimir);

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar fazer aposta, " + e.getMessage());
        }
        System.out.println(aposta.toString());

    }

    public void carregarRodada() {
        try {
            RodadaDao rodadaDao = new RodadaDao();
            List<Rodada> rodadas = rodadaDao.listar();
            for (Rodada rodada1 : rodadas) {
                if (rodada1.getSituacao().equals("a")) {
                    rodada = rodada1;
                }
            }
            if (rodada == null) {
                FacesUtil.addMsgInfo("Nenhuma Rodada em aberto");
            }

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar listar rodada " + e.getMessage());
        }
    }

    public void carregarAposta() {

        try {
            if (codigo != null) {
                ApostaDao apostaDao = new ApostaDao();
                aposta = apostaDao.buscarPorCodigo(codigo);
            } else {
                aposta = new Aposta();
            }
        } catch (Exception e) {
        }
    }

    public void novo() {
        aposta = new Aposta();
    }

    public void listar() {
        System.out.println("ENtrou no listar");
        try {
            ApostaDao apostaDao = new ApostaDao();
            apostas = apostaDao.listar();
            
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar listar Apostas "+e.getMessage());
            
        }
    }
}
