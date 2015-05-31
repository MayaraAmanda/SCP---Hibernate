/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Instituicao;
import model.Instituicao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class InstituicaoDAO {

    public static List<Instituicao> obterInstituicoes() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Instituicao> instituicoes = session.createCriteria(Instituicao.class).list();
        
        return instituicoes;
    }
   
    public static List<Instituicao> obterInstituicaoPorNome(String nomeInstituicao) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Instituicao> instituicoes = session.createQuery(
    "from instituicao where nome like '%' +nomeInstituicao+'%'").list();
    
    return instituicoes;
    }
 
    
    public static Instituicao obterInstituicao(int codigoInstituicao) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Instituicao instituicao = (Instituicao) session.load(Instituicao.class, codigoInstituicao);
        
        return instituicao;
        
    }
  
    public static void gravar(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(instituicao);
        transaction.commit();
        
    }
    
    public static void editar(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(instituicao);
        transaction.commit();
        
    }
    
     public static void excluir(Instituicao instituicao) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(instituicao);
        transaction.commit();
        
    }
    
    
}
