/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import model.Funcionario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Mayara Amanda
 */
public class FuncionarioDAO {
    
    
    public static List<Funcionario> obterFuncionarios() throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();   
        session.beginTransaction();
        session.clear();
        List<Funcionario> funcionarios = session.createCriteria(Funcionario.class).list();
        
        return funcionarios;
    }
   
    public static List<Funcionario> obterFuncionarioPorNome(String nomeFuncionario) throws SQLException, ClassNotFoundException {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.clear();
    List<Funcionario> funcionarios = session.createQuery(
    "from funcionario where nome like '%' +nomeFuncionario+'%'").list();
    
    return funcionarios;
    }
 
    
    public static Funcionario obterFuncionario(int matricula) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Funcionario funcionario = (Funcionario) session.load(Funcionario.class, matricula);
        
        return funcionario;
        
    }
  
    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(funcionario.getPessoas());
        session.save(funcionario);
        transaction.commit();
        
    }
    
    public static void editar(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(funcionario);
        session.update(funcionario.getPessoas());
        transaction.commit();
        
    }
    
     public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(funcionario);
        session.delete(funcionario.getPessoas());
        transaction.commit();
        
    }

}
