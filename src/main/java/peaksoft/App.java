package peaksoft;

import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;
import peaksoft.serviceImpls.CourseServiceImpl;
import peaksoft.serviceImpls.InstructorServiceImpl;
import peaksoft.serviceImpls.LessonServiceImpl;
import peaksoft.serviceImpls.TaskServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final CourseService courseService = new CourseServiceImpl();
    public static final InstructorService instructorService = new InstructorServiceImpl();
    public static final LessonService lessonService = new LessonServiceImpl();
    public static final TaskService taskService = new TaskServiceImpl();

    public static void main( String[] args )
    {
        Course course1 = new Course("Peaksoft","Grajdanskaya 119","01.09.2020",
                "dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A great!");
        Course course2 = new Course("Motion Web","Turusbekova 109/3","10.10.2019",
                "dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A good!");
        Course course3 = new Course("Attractor","Maldybaeva 7/1","20.04.2014",
                "dlina ssylki prevyshaet (225),mojete poluchit ego cherez ssylki saita!","A great!");

        Instructor instructor1 = new Instructor("Mukhammed","Batyrov","batyrovv@gmail.com","+996 700 700 700");
        Instructor instructor2 = new Instructor("Esen","Niyazov","niyazov94@gmail.com","+996 200 200 200");
        Instructor instructor3 = new Instructor("Burulai","Urbaeva","urbaeva2002@gmail.com","+996 777 777 777");
        Instructor instructor4 = new Instructor("Erzhigit","Kalmyzaev","erzhigitkalmyrzaev00@gmail.com","+996 555 100 100");

        Lesson lesson1 = new Lesson("JDBC","https://www.youtube.com/watch?v=nL9dnvoF_ng");
        Lesson lesson2 = new Lesson("OOP","https://www.youtube.com/watch?v=CHwzlHpp5CI");
        Lesson lesson3 = new Lesson("Hibernate","https://www.youtube.com/watch?v=xybmKzQ5s4c&list=PL8X2nqRlWfabWFN81Zi4vl30cZsdyxt6e");
        Lesson lesson4 = new Lesson("Apache Maven","https://www.youtube.com/watch?v=0uwMKktzixU");
        Lesson lesson5 = new Lesson("Spring Framework","https://www.youtube.com/watch?v=5ePo08sqcpk&list=PLAma_mKffTOR5o0WNHnY0mTjKxnCgSXrZ");

        Task task1 = new Task("Project 'TimeTable'","02.11.22","Creat!");
        Task task2 = new Task("Project 'Library'","01.11.22","Creat!");
        Task task3 = new Task("Project 'Course'","11.11.22","Creat!");
        Task task4 = new Task("Project 'Register'","01.11.22","Creat!");
        Task task5 = new Task("Project 'Company'","22.11.22","Creat!");
        Task task6 = new Task("Project 'Elevator'","16.11.22","Creat!");
        Task task7 = new Task("Project 'Calculate'","20.11.22","Creat!");

//        Nujnyi metoddu kommentariyden chygaryp ishtete bergile!

//        courseService.saveCourse(course2);
//        courseService.updateCourse(1L,course2);
//        System.out.println(courseService.getCourseById(1L));
//        System.out.println(courseService.getAllCourses());
//        courseService.deleteCourse(1L);
//        System.out.println(courseService.getCourseByName("Peaksoft"));
//
//        instructorService.saveInstructor(instructor3);
//        instructorService.updateInstructor(1L,instructor4);
//        System.out.println(instructorService.getInstructorById(1L));
//        instructorService.assignInstructorToCourse(2L,3L);
//        System.out.println(instructorService.getInstructorByCourseId(1L));
//        instructorService.deleteInstructorById(1L);
//
//        lessonService.saveLesson(2L,lesson1);
//        lessonService.updateLesson(2L,lesson4);
//        System.out.println(lessonService.getLessonById(1L));
//        System.out.println(lessonService.getLessonsByCourseId(1L));
//
//        taskService.saveTask(2L,task6);
//        taskService.updateTask(1L,task4);
//        System.out.println(taskService.getAllTasksByLessonId(1L));
//        taskService.deleteTaskById(1L);




    }
}
