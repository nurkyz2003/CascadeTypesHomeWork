package peaksoft.daoImpls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.TaskDao;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.util.Util;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    private final SessionFactory sessionFactory = Util.createSessionFactory();

    @Override
    public void saveTask(Long lessonId, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class,lessonId);
            task.setLesson(lesson);
            lesson.addTasksToLesson(task);
            session.merge(lesson);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e) {
            System.out.println("An error occurred -> (saveTask)!");
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Task updatedTask = session.get(Task.class, id);
            if (updatedTask == null) {
                System.out.println("Empty,no such course!");
            } else {
                updatedTask.setName(task.getName());
                updatedTask.setTask(task.getTask());
                updatedTask.setDeadline(task.getDeadline());
                session.merge(updatedTask);
                session.getTransaction().commit();
                session.close();
            }
        } catch (Exception e) {
            System.out.println("An error occurred -> (updateTask)!");
        }
    }

    @Override
    public List<Task> getAllTasksByLessonId(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Lesson lesson = session.find(Lesson.class,id);
            List<Task> taskList = lesson.getTasks();
            session.getTransaction().commit();
            session.close();
            return taskList;
        } catch (Exception exception) {
            System.out.println("An error occurred -> (getAllTaskByLessonId)!");
        }
        return null;
    }

    @Override
    public void deleteTaskById(Long id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Task task = session.get(Task.class,id);
            task.setLesson(null);
            session.remove(task);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println("An error occurred -> (deleteTaskById)!");
        }
    }
}
