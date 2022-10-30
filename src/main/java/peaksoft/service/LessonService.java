package peaksoft.service;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Long courseId, Lesson lesson);

    void updateLesson(Long id,Lesson lesson);

    Lesson getLessonById(Long id);

    List<Lesson> getLessonsByCourseId(Long id);
}
