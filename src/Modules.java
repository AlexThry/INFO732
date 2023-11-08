import java.util.ArrayList;

public class Modules {

    private String subject;
    private int moduleId;
    private ArrayList<Lesson> lessons = new ArrayList<>();

    private ArrayList<User> students = new ArrayList<>();

    public Modules(String subject, int moduleId) {
        this.subject = subject;
        this.moduleId = moduleId;
    }

    public void addStudents(User user){
        students.add(user);
    }

    public void addLesson(Lesson lesson){lessons.add(lesson);};

    public ArrayList<User> getStudents() {
        return students;
    }

    public ArrayList<String> getStudentsLogin() {
        ArrayList<String> studentsLogin = new ArrayList<>();
        for(User user : students){
            studentsLogin.add(user.getLogin());
        }
        return studentsLogin;
    }

    @Override
    public String toString() {
        String listeLesson = "";
        for(Lesson lesson : lessons){
            listeLesson += lesson.toString() + "\n";
        }
        return "Module de : " + "\n" +
                subject + "\n" +
                listeLesson;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(String type, Dates startDates, Dates endDates, String subject) {
        this.lessons.add(LessonFactory.createLesson(type, startDates, endDates, subject));
    }
}
