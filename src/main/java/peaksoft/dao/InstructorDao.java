package peaksoft.dao;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);

    void updateInstructor(Long id,Instructor instructor);

    Instructor getInstructorById(Long id);

    List<Instructor> getInstructorByCourseId(Long id);

    void deleteInstructorById(Long id);

    void assignInstructorToCourse(Long courseId,Long id);
}
