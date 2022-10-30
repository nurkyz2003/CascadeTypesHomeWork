package peaksoft.daoImpls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.InstructorDao;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.util.Util;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();
    private final SessionFactory sessionFactory = Util.createSessionFactory();

    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            EntityManager entityManager1 = entityManagerFactory.createEntityManager();
            entityManager1.getTransaction().begin();
            entityManager1.persist(new Instructor(instructor.getFirstName(), instructor.getLastName(), instructor.getEmail(), instructor.getPhoneNumber()));
            entityManager1.getTransaction().commit();
            entityManager1.close();
        } catch (Exception e) {
            System.out.println("An error occurred! -> (saveInstructor)");
        }
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor updatedInstructor = session.find(Instructor.class, id);
            updatedInstructor.setCourse(instructor.getCourse());
            updatedInstructor.setEmail(instructor.getEmail());
            updatedInstructor.setFirstName(instructor.getFirstName());
            updatedInstructor.setLastName(instructor.getLastName());
            updatedInstructor.setPhoneNumber(instructor.getPhoneNumber());
            session.merge(updatedInstructor);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (updateInstructor)!");
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class, id);
            if (instructor==null){
                System.out.println("Empty,no such instructor!");
            }
            session.getTransaction().commit();
            session.close();
            return instructor;
        } catch (Exception e) {
            System.out.println("An error occurred -> (getInstructorById)!");
        }
        return null;
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        try { Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            List<Instructor> instructors = course.getInstructors();
            session.getTransaction().commit();
            session.close();
            return instructors;
        } catch (Exception e) {
            System.out.println("An error occurred -> (getInstructorByCourseId)!");
        }
        return null;
    }

    @Override
    public void deleteInstructorById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Instructor instructor = session.find(Instructor.class, id);
            session.remove(instructor);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (deleteInstructorById)!");
        }
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course == null) {
                System.out.println("Empty,no such course!");
            } else {
                Instructor instructor = session.get(Instructor.class,id);
                if (instructor == null){
                    System.out.println("Empty,no such instructor!");
                } else {
                    instructor.getCourse().add(course);
                    session.merge(instructor);
                }
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (assignInstructorToCourse)!");
        }
    }
}
