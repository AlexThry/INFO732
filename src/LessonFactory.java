public abstract class LessonFactory {

    public Lesson createLesson(String type, Date startDate, Date endDate, String subject) {
        Lesson lesson = null;
        if (type == "TD") {
            lesson = new TD(startDate, endDate, subject);
        } else if (type == "TP") {
            lesson = new TP(startDate, endDate, subject);
        } else if (type == "CC") {
            lesson = new CC(startDate, endDate, subject);
        }
        return lesson;
    }
}
