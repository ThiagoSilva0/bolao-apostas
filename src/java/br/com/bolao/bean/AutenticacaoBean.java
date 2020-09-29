/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.bean;

import br.com.bolao.dao.UsuarioDao;
import br.com.bolao.domain.Usuario;
import br.com.bolao.util.FacesUtil;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thiag
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean {

    private Usuario usuarioLogado;

    public Usuario getUsuarioLogado() {
        if (usuarioLogado == null) {
            usuarioLogado = new Usuario();
        }
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    @PostConstruct
    public void autenticar() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioLogado = usuarioDao.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
            if (usuarioLogado == null) {
                FacesUtil.addMsgErro("Login ou Senha inválidos!");
            } else {
                FacesUtil.addMsgInfo("Usuario autenticado com suacesso!");
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Principal.xhtml?faces-redirect=true");
            }

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar autenticar: " + e.getMessage());
        }catch(IOException ex){
            FacesUtil.addMsgErro("Erro ao tentar Redirecionar: " + ex.getMessage());
        }
    }

    public void sair() {
      
        usuarioLogado = new Usuario();
        System.out.println(usuarioLogado);
        System.out.println(usuarioLogado.toString());
        try {

            FacesContext.getCurrentInstance().getExternalContext().redirect("../Principal.xhtml?faces-redirect=true");

        } catch (IOException e) {
            FacesUtil.addMsgErro("Erro ao tentar redirecionar " + e.getMessage());
        }
    }

    public void redirecionarSemLogar() {

        try {
            if (usuarioLogado.getCodigo() == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?faces-redirect=true");
            }
            
        } catch (IOException e) {
            FacesUtil.addMsgErro("Erro ao tentar redirecionar " + e.getMessage());
        }
    }

    public void redirecionarSemPermicao() {

        try {
            System.out.println("Funcao " + usuarioLogado.getFuncao());
            if (usuarioLogado.getFuncao().compareTo("A") != 0) {
                
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Principal.xhtml?faces-redirect=true");
            }
            
        } catch (IOException e) {
            FacesUtil.addMsgErro("Erro ao tentar redirecionar " + e.getMessage());
        }
    }
}
