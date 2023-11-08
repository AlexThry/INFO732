import java.util.ArrayList;

public abstract class Lesson {
    private ArrayList<Homework> homeworks = new ArrayList<>();
    private Date startDate;
    private Date endDate;
    private String subject;
    private ArrayList<Grade> grades = new ArrayList<>();

    public Lesson(Date startDate, Date endDate, String subject) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
                "commence le : " + startDate.toString() + "\n" +
                "finit le : " + endDate.toString() + "\n" +
                "moyenne : " + getAverage();
    }
}
