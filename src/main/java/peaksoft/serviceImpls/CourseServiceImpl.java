package peaksoft.serviceImpls;

import peaksoft.dao.CourseDao;
import peaksoft.daoImpls.CourseDaoImpl;
import peaksoft.model.Course;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id,course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDao.getCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }
}
