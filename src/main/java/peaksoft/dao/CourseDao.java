package peaksoft.dao;

import peaksoft.model.Course;

import java.util.List;

public interface CourseDao {
    void saveCourse(Course course);

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void updateCourse(Long id,Course course);

    void deleteCourse(Long id);

    Course getCourseByName(String name);
}
