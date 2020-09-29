/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bolao.dao;

import br.com.bolao.domain.Aposta;
import br.com.bolao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author thiag
 */
public class ApostaDao {

    public void salvar(Aposta aposta) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(aposta);
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

    public List<Aposta> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        List<Aposta> fabricantes = null;
        try {
            Query consulta = sessao.createQuery("From Aposta");
            fabricantes = consulta.list();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            try {
                sessao.close();
            } catch (Exception e) {
                throw e;
            }
        }
        return fabricantes;
    }

    public Aposta buscarPorCodigo(Long codigo) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Aposta aposta = null;
        try {
            Query consulta = (Query) sessao.createQuery("Select aposta FROM Aposta aposta WHERE aposta.codigo like :codigo");
            consulta.setLong("codigo", codigo);
            aposta = (Aposta) consulta.uniqueResult();
        } catch (RuntimeException ex) {
            throw ex;
        } finally {
            sessao.close();
        }
        return aposta;
    }

    public void excluir(Aposta aposta) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().getCurrentSession();
            transacao = sessao.beginTransaction();
            sessao.delete(aposta);
            transacao.commit();
        } catch (RuntimeException ex) {

            throw ex;
        } finally {
            sessao.close();
        }
    }

    public void editar(Aposta aposta) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
//            Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//            fabricanteEditar.setDescricao(fabricante.getDescricao());
//            sessao.update(fabricanteEditar);
            sessao.update(aposta);
            transacao.commit();
        } catch (RuntimeException ex) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw ex;
        } finally {
//            sessao.close();
        }
    }

   

}
