import java.util.ArrayList;

public abstract class Lesson {
    private ArrayList<Homework> homeworks = new ArrayList<>();
    private Dates startDates;
    private Dates endDates;
    private String subject;
    private ArrayList<Grade> grades = new ArrayList<>();

    public Lesson(Dates startDates, Dates endDates, String subject) {
        this.startDates = startDates;
        this.endDates = endDates;
        this.subject = subject;
    }

    private void update() {}

    private void addHomework(Homework homework) {
        this.homeworks.add(homework);
    }

    public ArrayList<Homework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(ArrayList<Homework> homeworks) {
        this.homeworks = homeworks;
    }

    public Dates getStartDate() {
        return startDates;
    }

    public void setStartDate(Dates startDates) {
        this.startDates = startDates;
    }

    public Dates getEndDate() {
        return endDates;
    }

    public void setEndDate(Dates endDates) {
        this.endDates = endDates;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public int getAverage(){
        int sum = 0;
        for(Grade grade : grades){
            sum += grade.getValue();
        }
        if(grades.size() == 0){
            return 10;
        }else {
            return (sum/grades.size());
        }
    }

    @Override
    public String toString() {
        return "cours de : " + subject + "\n" +
                "commence le : " + startDates.toString() + "\n" +
                "finit le : " + endDates.toString() + "\n" +
                "moyenne : " + getAverage();
    }
}
