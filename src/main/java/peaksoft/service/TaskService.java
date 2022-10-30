package peaksoft.service;

import peaksoft.model.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Long lessonId, Task task);

    void updateTask(Long id,Task task);

    List<Task> getAllTasksByLessonId(Long id);

    void deleteTaskById(Long id);
}
