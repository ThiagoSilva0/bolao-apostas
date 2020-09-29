/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.dao;

import br.com.bolao.domain.Aposta;
import br.com.bolao.domain.Jogo;
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
public class JogoDao {

    public void salvar(Jogo jogo) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(jogo);
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
    public List<Jogo> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        List<Jogo> jogos = null;
        try {
            Query consulta = sessao.createQuery("From Jogo");
            jogos = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            try {
                sessao.close();
            } catch (Exception e) {
                throw e;
            }
        }
        return jogos;
    }

    public Jogo buscarPorCodigo(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Jogo jogo = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select jogo FROM Jogo jogo WHERE jogo.codigo like :codigo");
            consulta.setLong("codigo", codigo);
            jogo = (Jogo) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return jogo;
    }

    public void excluir(Jogo jogo) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();
            sessao.delete(jogo);
            transacao.commit();
        } catch (RuntimeException ex) {

            throw ex;
        } finally {
          //  sessao.close();
        }
    }

    public void editar(Jogo jogo) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
//            Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//            fabricanteEditar.setDescricao(fabricante.getDescricao());
//            sessao.update(fabricanteEditar);
            sessao.update(jogo);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
            //sessao.close();
        }
    }
}
