/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Curso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class CursoDAO {
 
    public static List<Curso> obterCursos() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Curso> cursos = session.createCriteria(Curso.class).list();
        
        return cursos;
    }
   
    public static List<Curso> obterCursoPorNome(String nomeCurso) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Curso> cursos = session.createQuery(
    "from curso where nome like '%'" +nomeCurso+"'%'").list();
    
    return cursos;
    }
 
    
    public static Curso obterCurso(int codigoCurso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Curso curso = (Curso)session.createQuery("from Curso where codigoCurso =" + codigoCurso).list().get(0);
        //Curso curso = (Curso) session.load(Curso.class, codigoCurso);
        
        return curso;
        
    }
  
    public static void gravar(Curso curso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(curso);
        transaction.commit();
        
    }
    
    public static void editar(Curso curso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(curso);
        transaction.commit();
        
    }
    
     public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(curso);
        transaction.commit();
        
    }
    
    
}
