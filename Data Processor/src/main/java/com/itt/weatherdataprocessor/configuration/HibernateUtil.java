package com.itt.weatherdataprocessor.configuration;

import com.itt.weatherdataprocessor.beans.Hourly;
import com.itt.weatherdataprocessor.beans.Weather;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author kratiyag.gupta
 */
public class HibernateUtil {

    /**
     * Holds the session factory object
     */
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Properties prop = new Properties();
            try {
                prop.load(HibernateUtil.class.getClassLoader().
                        getSystemClassLoader().getResourceAsStream(
                        "C:\\Users\\kratiyag.gupta\\Documents\\NetBeansProjects"
                                + "\\HibernateAnno\\src\\main\\resources"
                                + "\\hibernate.properties"));
            }
            catch (Exception e) {
            }
            return new Configuration().mergeProperties(getHibernateProperties())
                .addPackage("com.itt.hibernateanno.beans")
                .addAnnotatedClass(Hourly.class)
                .addAnnotatedClass(Weather.class)
                .configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     *
     * @return SessionFactoy Object
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.generate_statistics", "true");
        properties.put("hibernate.id.new_generator_mappings", "false");
        return properties;
    }
}
