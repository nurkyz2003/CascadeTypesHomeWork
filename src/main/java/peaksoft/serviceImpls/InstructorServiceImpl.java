package peaksoft.serviceImpls;

import peaksoft.dao.InstructorDao;
import peaksoft.daoImpls.InstructorDaoImpl;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private final InstructorDao instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long courseId, Long id) {
        instructorDao.assignInstructorToCourse(courseId,id);
    }
}
