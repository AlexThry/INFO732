import java.util.ArrayList;

public class Modules {

    private String subject;
    private int moduleId;
    private ArrayList<Lesson> lessons = new ArrayList<>();

    private ArrayList<Student> students = new ArrayList<>();

    public Modules(String subject, int moduleId) {
        this.subject = subject;
        this.moduleId = moduleId;
    }

    public void addStudents(Student student){
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<String> getStudentsLogin() {
        ArrayList<String> studentsLogin = new ArrayList<>();
        for(Student student : students){
            studentsLogin.add(student.getLogin());
        }
        return studentsLogin;
    }

    @Override
    public String toString() {
        return "Modules de : " +
                subject;
    }
}
