/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Bolsista;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class BolsistaDAO {
    
    public static List<Bolsista> obterBolsistas() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Bolsista> bolsistas = session.createCriteria(Bolsista.class).list();
        
        return bolsistas;
    }
   
    public static List<Bolsista> obterBolsistaPorNome(String nomeBolsista) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Bolsista> bolsistas = session.createQuery(
    "from bolsista where nome like '%' +nomeBolsista+'%'").list();
    
    return bolsistas;
    }
 
    
    public static Bolsista obterBolsista(int matricula) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Bolsista bolsista = (Bolsista) session.load(Bolsista.class, matricula);
        
        return bolsista;
        
    }
  
    public static void gravar(Bolsista bolsista) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(bolsista.getPessoas());
        session.save(bolsista);
        transaction.commit();
        
    }
    
    public static void editar(Bolsista bolsista) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(bolsista);
        session.update(bolsista.getPessoas());
        transaction.commit();
        
    }
    
     public static void excluir(Bolsista bolsista) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(bolsista);
        session.delete(bolsista.getPessoas());
        transaction.commit();
        
    }
}
