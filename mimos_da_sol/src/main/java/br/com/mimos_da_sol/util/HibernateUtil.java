package br.com.mimos_da_sol.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
   private static final SessionFactory sessionFactory;
   
   public static final String HIBERNATE_SESSION = "hibernate_session";
   
   static {
       try {
           System.out.println("tentando abrir a session Factory");
           Configuration configuration = new Configuration().configure();
           ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                   applySettings(configuration.getProperties()).buildServiceRegistry();
           sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           System.out.println("Session Factory criada corretamente");
       } catch (Exception ex) {System.out.println("Ocorreu um erro ao iniciar a Session Factory " + ex);
           throw new ExceptionInInitializerError(ex);
       }
   }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   
   
   
}
