/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.SQLException;
import java.util.List;
import model.Campus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author Angelo
 */
public class CampusDAO {
    public static Campus obterCampus (int codigo) throws ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        Campus campus = (Campus) session.load(Campus.class, codigo);
        //Campus campus = (Campus)session.createQuery("from Campus where codigoCampus =" + codigo ).list().get(0);
       
        
        return campus;
    }
    public static List<Campus> obterCampi() throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Campus> campi = session.createCriteria(Campus.class).list();
        return campi;
    }
    public static List<Campus> obterCampiPorNome(String nome) throws ClassNotFoundException, SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.clear();
        List<Campus> campi = session.createQuery("from Campus where nome like '%" + nome + "%'").list();
        return campi;
    }
    
    
    public static void gravar(Campus campus) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.save(campus);
        transaction.commit();
    }
    
    public static void editar(Campus campus) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.update(campus);
        transaction.commit();
    }
    
    public static void excluir(Campus campus) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.clear();
        session.delete(campus);
        transaction.commit();
    }
}