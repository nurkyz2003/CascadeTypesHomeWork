package peaksoft.daoImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.LessonDao;
import peaksoft.model.Course;
import peaksoft.model.Lesson;
import peaksoft.util.Util;

import java.util.List;

public class LessonDaoImpl implements LessonDao {
    private final SessionFactory sessionFactory = Util.createSessionFactory();

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.get(Course.class,courseId);
            if (course == null) {
                System.out.println("No such course!)");
            } else {
                lesson.setCourse(course);
                session.merge(lesson);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            System.out.println("An error occurred! -> (saveLesson)!");
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson updatedLesson = session.get(Lesson.class, id);
            if (updatedLesson == null) {
                System.out.println("No such course!");
            } else {
                updatedLesson.setName(lesson.getName());
                updatedLesson.setVideoLink(lesson.getVideoLink());
                updatedLesson.setTasks(lesson.getTasks());
                updatedLesson.setCourse(lesson.getCourse());
                session.merge(updatedLesson);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception e) {
            System.out.println("An error occurred! -> (updateLesson)!");
        }
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class, id);
            if (lesson == null) {
                System.out.println("Empty,no such lesson!");
            }
            session.getTransaction().commit();
            session.close();
            return lesson;
        } catch (Exception e) {
            System.out.println("An error occurred! -> (getLessonById)!");
        }
        return null;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Course course = session.find(Course.class,id);
            List<Lesson> lessons = course.getLessons();
            session.getTransaction().commit();
            session.close();
            return lessons;
        } catch(Exception e){
            System.out.println("An error occurred! -> (getLessonsByCourseId)!");
        }
        return null;
    }
}
