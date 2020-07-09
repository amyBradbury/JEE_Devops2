/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author jorda
 */
public class HibernateSession {
    private static final SessionFactory _sessionFactory;
    static
    {
        try{
            _sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch(Throwable ex)
        {
           System.err.println("L'initialisation a échoué " + ex );
           throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory GetSession()
    {
        return _sessionFactory;
    }
    public static void CloseSession()
    {
        _sessionFactory.close();
    }
    
}
