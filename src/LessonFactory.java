public abstract class LessonFactory {

    public static Lesson createLesson(String type, Date startDate, Date endDate, String subject) {
        Lesson lesson = null;
        if (type.toUpperCase().equals("TD")) {
            lesson = new TD(startDate, endDate, subject);
        } else if (type.toUpperCase().equals("TP")) {
            lesson = new TP(startDate, endDate, subject);
        } else if (type.toUpperCase().equals("CC")) {
            lesson = new CC(startDate, endDate, subject);
        }
        return lesson;
    }
}
