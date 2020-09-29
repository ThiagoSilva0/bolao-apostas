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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thiag
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private List<Usuario> listaUsuariosFiltrado;
    private String acao;
    private Long codigo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Usuario> getListaUsuariosFiltrado() {
        return listaUsuariosFiltrado;
    }

    public void setListaUsuariosFiltrado(List<Usuario> listaUsuariosFiltrado) {
        this.listaUsuariosFiltrado = listaUsuariosFiltrado;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public void salvar() {

        try {
            //Verificando se já existe cadastro com esse login
            UsuarioDao usuarioDao = new UsuarioDao();
            List<Usuario> usuarios = usuarioDao.listar();
            boolean autorizacao = true;
            for (Usuario usuario1 : usuarios) {
                if (usuario1.getLogin().equals(usuario.getLogin())) {

                    autorizacao = false;
                }
            }
            if (autorizacao == true) {
                usuarioDao.salvar(usuario);
                FacesUtil.addMsgInfo("Usuário " + usuario.getNome() + " cadastrado com sucesso!");
                usuario = new Usuario();
            } else {
                FacesUtil.addMsgErro("Login já existente");
            }
            
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar cadastrar usuário!" + e.getMessage());
        }

    }

    public void novo() {
        usuario = new Usuario();
    }

    public void listar() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            listaUsuarios = usuarioDao.listar();

        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar listar os usuários!" + e.getMessage());
        }
    }

    public void carregarCadastro() {

        try {

            if (codigo != null) {

                UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.buscarPorCodigo(codigo);
            } else {
                usuario = new Usuario();
            }
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar obter dados do usuário!" + e.getMessage());
        }
    }

    public void editar() {

        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.editar(usuario);
            FacesUtil.addMsgInfo("Usuário editado com sucesso!");

            usuario = new Usuario();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar editar usuário!" + e.getMessage());
        }

    }

    public void excluir() {

        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            usuarioDao.excluir(usuario);
            FacesUtil.addMsgInfo("Usuário excluido com sucesso!");

            usuario = new Usuario();
        } catch (RuntimeException e) {
            FacesUtil.addMsgErro("Erro ao tentar excluir usuário!" + e.getMessage());
        }

    }

    public void teste() {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?faces-redirect=true");
        } catch (IOException e) {
            FacesUtil.addMsgErro("ERRO " + e.getMessage());
        }
    }
}
