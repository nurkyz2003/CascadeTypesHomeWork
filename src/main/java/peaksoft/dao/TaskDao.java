package peaksoft.dao;

import peaksoft.model.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Long lessonId, Task task);

    void updateTask(Long id,Task task);

    List<Task> getAllTasksByLessonId(Long id);

    void deleteTaskById(Long id);
}
