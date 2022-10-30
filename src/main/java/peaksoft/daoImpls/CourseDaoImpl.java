package peaksoft.daoImpls;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.CourseDao;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.util.Util;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final EntityManagerFactory entityManagerFactory = Util.createEntityManagerFactory();
    private final SessionFactory sessionFactory = Util.createSessionFactory();

    @Override
    public void saveCourse(Course course) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(new Course(course.getName(), course.getDuration(), course.getCreateAt(), course.getImageLink(), course.getDescription()));
            session.getTransaction().commit();
        }
    }

    @Override
    public Course getCourseById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            if (course==null){
                System.out.println("Empty, no such course!");
            }
            session.getTransaction().commit();
            session.close();
            return course;
        } catch (Exception e) {
            System.out.println("An error occurred -> (getCourseById)!");
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c order by c.createAt").list();
            session.getTransaction().commit();
            session.close();
            return courses;
        } catch (Exception e){
            System.out.println("An error occurred -> (getAllCourses)!");
        }
        return null;
    }

    @Override
    public void updateCourse(Long id, Course course) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course updatedCourse = session.find(Course.class, id);
            updatedCourse.setName(course.getName());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setDuration(course.getDuration());
            updatedCourse.setLessons(course.getLessons());
            updatedCourse.setCreateAt(course.getCreateAt());
            updatedCourse.setImageLink(course.getImageLink());
            updatedCourse.setInstructors(course.getInstructors());
            session.merge(updatedCourse);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (updateCourse)!");
        }
    }

    @Override
    public void deleteCourse(Long id) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class,id);
            for (Instructor instructor : course.getInstructors()) {
                instructor.setCourse(null);
            }
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (deleteCourse)!");
        }
    }

    @Override
    public Course getCourseByName(String name) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Course> courses = session.createQuery("select c from Course c", Course.class).list();
            for ( Course course : courses) {
                if(course.getName().equals(name)){
                    return course;
                } else {
                    System.out.println("Empty,no such course!");
                }
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (getCourseByName)!");
        }
        return null;
    }
}
