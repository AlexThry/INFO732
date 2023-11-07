public class Homework extends ToDo {
    private String type;
    private String homework;

    public Homework(String content, Boolean isDone, String type, String homework) {
        super(content, isDone);
        this.type = type;
        this.homework = homework;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
}
