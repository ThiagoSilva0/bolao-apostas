/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.dao;

import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Usuario;
import br.com.bolao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thiag
 */
public class UsuarioDao {

    public void salvar(Usuario usuario) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(usuario);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
            sessao.close();
        }

    }

    public List<Usuario> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        List<Usuario> usuarios = null;
        try {
            Query consulta = sessao.createQuery("From Usuario");
            usuarios = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            try {
                sessao.close();
            } catch (Exception e) {
                throw e;
            }
        }
        return usuarios;
    }

    public Usuario buscarPorCodigo(long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Usuario usuario = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select usuario FROM Usuario usuario WHERE usuario.codigo like :codigo");
            consulta.setLong("codigo", codigo);
            usuario = (Usuario) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return usuario;
    }

    public void excluir(Usuario usuario) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();
            sessao.delete(usuario);
            transacao.commit();
        } catch (RuntimeException ex) {

            throw ex;
        } finally {
        //    sessao.close();
        }
    }

    public void editar(Usuario usuario) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
//            Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//            fabricanteEditar.setDescricao(fabricante.getDescricao());
//            sessao.update(fabricanteEditar);
            sessao.update(usuario);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
          //  sessao.close();
        }
    }

    public Usuario autenticar(String login, String senha) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select usuario FROM Usuario usuario WHERE usuario.login like :login and usuario.senha like :senha");
            consulta.setString("login", login);
            consulta.setString("senha", senha);
            
            usuario = (Usuario) consulta.uniqueResult();
        } catch (RuntimeException e) {
            throw e;
        }finally{
          sessao.close();
        }
        return usuario;
    }
    
    public Usuario buscarPorLogin(String login) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Usuario usuario = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select usuario FROM Usuario usuario WHERE usuario.login like :login");
            consulta.setString("login", login);
            usuario = (Usuario) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return usuario;
    }
}
