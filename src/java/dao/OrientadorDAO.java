/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Orientador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class OrientadorDAO {
    
    public static List<Orientador> obterOrientadores() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Orientador> orientadores = session.createCriteria(Orientador.class).list();
        
        return orientadores;
    }
   
    public static List<Orientador> obterOrientadorPorNome(String nomeOrientador) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Orientador> orientadores = session.createQuery(
    "from orientador where nome like '%' +nomeOrientador+'%'").list();
    
    return orientadores;
    }
 
    
    public static Orientador obterOrientador(int codigo) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
       // Orientador orientador = (Orientador) session.load(Orientador.class, matricula);
        
        List<Orientador> list = session.createCriteria(Orientador.class).list();
            for(int i = 0; i<=list.size()-1; i++){
                if(list.get(i).getMatricula() == codigo){
                    return (Orientador) list.get(i);
                }
            }
        
        return null;
        
    }
  
    public static void gravar(Orientador orientador) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(orientador.getPessoas());
        session.save(orientador);
        transaction.commit();
        
    }
    
    public static void editar(Orientador orientador) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(orientador);
        session.update(orientador.getPessoas());
        transaction.commit();
        
    }
    
     public static void excluir(Orientador orientador) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(orientador);
        session.delete(orientador.getPessoas());
        transaction.commit();
        
    }
}
