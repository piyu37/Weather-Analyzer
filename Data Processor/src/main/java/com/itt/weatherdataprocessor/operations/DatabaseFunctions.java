
package com.itt.weatherdataprocessor.operations;

import com.itt.weatherdataprocessor.beans.Weather;
import com.itt.weatherdataprocessor.configuration.HibernateUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author kratiyag.gupta
 *
 * Contatins all the methods which deals with the modification of the data in
 * the database
 */
public class DatabaseFunctions
  {

    FileInputStream fis;
    Properties props;
    Configuration configuration;
    Session session;
    Scanner in;

    public DatabaseFunctions()
      {
        try
          {
            in = new Scanner(System.in);
            fis = new FileInputStream("C:\\Users\\kratiyag.gupta\\Documents"
                    + "\\NetBeansProjects\\HibernateAnno\\src\\main"
                    + "\\resources\\hibernate.properties");
            Properties props = new Properties();
            props.load(fis);
            configuration = new Configuration();
            configuration.setProperties(props);
          }
        catch (Exception ex)
          {
            System.out.println(ex.getMessage());
          }

      }

    /**
     * Inserting data in the Employee table using persistence class
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void insertData(Object data) throws FileNotFoundException, IOException
      {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(data);
        session.getTransaction().commit();
        session.close();
      }

    /**
     * For Deleting the data from Employee table
     */
    public void deletedData()
      {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
      }

    /**
     * For Updating the data in employee table
     */
    public void updateData()
      {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
      }
  }
