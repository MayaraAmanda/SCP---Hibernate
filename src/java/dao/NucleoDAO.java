/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Nucleo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class NucleoDAO {
    
    public static List<Nucleo> obterNucleos() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Nucleo> nucleos = session.createCriteria(Nucleo.class).list();
        
        return nucleos;
    }
   
    public static List<Nucleo> obterNucleoPorNome(String nomeNucleo) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Nucleo> nucleos = session.createQuery(
    "from nucleo where nome like '%' +nomeNucleo+'%'").list();
    
    return nucleos;
    }
 
    
    public static Nucleo obterNucleo(int codigoNucleo) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Nucleo nucleo = (Nucleo) session.load(Nucleo.class, codigoNucleo);
        
        return nucleo;
        
    }
  
    public static void gravar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(nucleo);
        transaction.commit();
        
    }
    
    public static void editar(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(nucleo);
        transaction.commit();
        
    }
    
     public static void excluir(Nucleo nucleo) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(nucleo);
        transaction.commit();
        
    }
}
