/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.dao;

import br.com.bolao.domain.Rodada;
import br.com.bolao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thiag
 */
public class RodadaDao {
    
        public void salvar(Rodada rodada) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(rodada);
            transacao.commit();
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw e;
        } finally {
           // sessao.close();
        }

    }

    public List<Rodada> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        List<Rodada> rodadas = null;
        try {
            Query consulta = sessao.createQuery("From Rodada");
            rodadas = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            try {
                sessao.close();
            } catch (Exception e) {
                throw e;
            }
        }
        return rodadas;
    }

    public Rodada buscarPorCodigo(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Rodada rodada = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select rodada FROM Rodada rodada WHERE rodada.codigo like :codigo");
            consulta.setLong("codigo", codigo);
            rodada = (Rodada) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return rodada;
    }

    public void excluir(Rodada rodada) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();
            sessao.delete(rodada);
            transacao.commit();
        } catch (RuntimeException ex) {

            throw ex;
        } finally {
           // sessao.close();
        }
    }

    public void editar(Rodada rodada) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
//            Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//            fabricanteEditar.setDescricao(fabricante.getDescricao());
//            sessao.update(fabricanteEditar);
            sessao.update(rodada);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
         //   sessao.close();
        }
    }

    public List<Rodada> buscarPorCodigo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
