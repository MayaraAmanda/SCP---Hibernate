/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Projeto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class ProjetoDAO {

    public static List<Projeto> obterProjetos() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Projeto> projetos = session.createCriteria(Projeto.class).list();
        
        return projetos;
    }
   
    public static List<Projeto> obterProjetoPorNome(String nomeProjeto) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Projeto> projetos = session.createQuery(
    "from projeto where nome like '%' +nomeProjeto+'%'").list();
    
    return projetos;
    }
 
    
    public static Projeto obterProjeto(int codigoProjeto) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Projeto projeto = (Projeto)session.createQuery("from Projeto where codigoProjeto =" + codigoProjeto).list().get(0);
//Projeto projeto = (Projeto) session.load(Projeto.class, codigoProjeto);
        
        return projeto;
        
    }
  
    public static void gravar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(projeto);
        transaction.commit();
        
    }
    
    public static void editar(Projeto projeto) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(projeto);
        transaction.commit();
        
    }
    
     public static void excluir(Projeto projeto) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(projeto);
        transaction.commit();
        
    }
    
    
}
