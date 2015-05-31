/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.SubArea;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class SubAreaDAO {

      
    public static List<SubArea> obterSubAreas() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<SubArea> subAreas = session.createCriteria(SubArea.class).list();
        
        return subAreas;
    }
   
    public static List<SubArea> obterSubAreaPorNome(String nomeSubArea) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<SubArea> subAreas = session.createQuery(
    "from subArea where nome like '%' +nomeSubArea+'%'").list();
    
    return subAreas;
    }
 
    
    public static SubArea obterSubArea(int codigoSubArea) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        SubArea subArea = (SubArea) session.load(SubArea.class, codigoSubArea);
        
        return subArea;
        
    }
  
    public static void gravar(SubArea subArea) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(subArea);
        transaction.commit();
        
    }
    
    public static void editar(SubArea subArea) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(subArea);
        transaction.commit();
        
    }
    
     public static void excluir(SubArea subArea) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(subArea);
        transaction.commit();
        
    }
    
    
}
