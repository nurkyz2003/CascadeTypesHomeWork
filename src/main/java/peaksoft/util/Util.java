package peaksoft.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.model.Lesson;
import peaksoft.model.Task;

import java.util.Properties;

public class Util {
    public static EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("peaksoft");
    }
    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/db");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "nurkyz200319yearsss");


        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");


        org.hibernate.cfg.Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);

        return configuration.buildSessionFactory();

    }
}
