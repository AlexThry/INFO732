public class ToDo {
    private String content;
    private Boolean isDone;

    public ToDo(String content, Boolean isDone) {
        this.content = content;
        this.isDone = isDone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        String done = "fait";
        if(!isDone){
            done = "à faire";
        }
        return content + ", " + done;
    }
}
