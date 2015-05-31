/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Tipobolsa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class TipoBolsaDAO {

      
    public static List<Tipobolsa> obterTipoBolsas() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Tipobolsa> tipoBolsas = session.createCriteria(Tipobolsa.class).list();
        
        return tipoBolsas;
    }
   
    public static List<Tipobolsa> obterTipoBolsaPorNome(String nomeTipoBolsa) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Tipobolsa> tipoBolsas = session.createQuery(
    "from tipoBolsa where nome like '%' +nomeTipoBolsa+'%'").list();
    
    return tipoBolsas;
    }
 
    
    public static Tipobolsa obterTipoBolsa(int codigoTipoBolsa) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Tipobolsa tipoBolsa = (Tipobolsa) session.load(Tipobolsa.class, codigoTipoBolsa);
        
        return tipoBolsa;
        
    }
  
    public static void gravar(Tipobolsa tipoBolsa) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(tipoBolsa);
        transaction.commit();
        
    }
    
    public static void editar(Tipobolsa tipoBolsa) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(tipoBolsa);
        transaction.commit();
        
    }
    
     public static void excluir(Tipobolsa tipoBolsa) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(tipoBolsa);
        transaction.commit();
        
    }
    
    
}
