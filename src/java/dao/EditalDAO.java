/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Edital;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class EditalDAO {
 
    public static List<Edital> obterEditais() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Edital> editais = session.createCriteria(Edital.class).list();
        
        return editais;
    }
   
    public static List<Edital> obterEditalPorNome(String nomeEdital) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Edital> editais = session.createQuery(
    "from edital where nome like '%' +nomeEdital+'%'").list();
    
    return editais;
    }
 
    
    public static Edital obterEdital(int codigoEdital) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Edital edital = (Edital) session.load(Edital.class, codigoEdital);
        
        return edital;
        
    }
  
    public static void gravar(Edital edital) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(edital);
        transaction.commit();
        
    }
    
    public static void editar(Edital edital) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(edital);
        transaction.commit();
        
    }
    
     public static void excluir(Edital edital) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(edital);
        transaction.commit();
        
    }
    
}
