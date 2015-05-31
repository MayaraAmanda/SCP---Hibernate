/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.Tipocurso;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author Mayara Amanda
 */
public class TipoCursoDAO {
    
    public static List<Tipocurso> obterTipoCursos() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Tipocurso> tipoCursos = session.createCriteria(Tipocurso.class).list();
        
        return tipoCursos;
    }

    
    public static List<Tipocurso> obterTipoCursoPorNome(String nomeTipoCurso) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Tipocurso> tipoCursos = session.createQuery(
    "from tipoCurso where nome like '%' "+nomeTipoCurso+"'%'").list();
    
    return tipoCursos;
    }
 
    
    public static Tipocurso obterTipoCurso(int codigoTipoCurso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Tipocurso tipoCurso = (Tipocurso) session.load(Tipocurso.class, codigoTipoCurso);
        
        return tipoCurso;
        
    }
  
    public static void gravar(Tipocurso tipoCurso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(tipoCurso);
        transaction.commit();
        
    }
    
    public static void editar(Tipocurso tipoCurso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(tipoCurso);
        transaction.commit();
        
    }
    
     public static void excluir(Tipocurso tipoCurso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(tipoCurso);
        transaction.commit();
        
    }
    
    
}
