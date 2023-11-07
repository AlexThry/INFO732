import java.util.ArrayList;

public abstract class Lesson {
    private ArrayList<Homework> homeworks = new ArrayList<>();
    private Date startDate;
    private Date endDate;
    private String subject;

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
}
