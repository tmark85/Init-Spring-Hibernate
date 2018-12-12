/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.LoadEventListener;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author trainer
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration conf = new Configuration();
            
            //Branchement Interceptors
            conf.setInterceptor(new IntercepteurExemple());
   
            sessionFactory = conf.configure().buildSessionFactory();
            
            // Branchement des listeners
            sessionFactory.unwrap(SessionFactoryImplementor.class).getServiceRegistry().getService( EventListenerRegistry.class ).prependListeners(EventType.LOAD, new MonEcouteur());
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void stop() throws Exception {
        sessionFactory.close();
    }
  
}
