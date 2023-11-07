import java.util.ArrayList;

public class Modules {

    private String subject;
    private int moduleId;
    private ArrayList<Lesson> lessons = new ArrayList<>();

    public Modules(int moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "Modules de : " +
                subject + moduleId;
    }
}
