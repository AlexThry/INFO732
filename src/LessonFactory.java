public abstract class LessonFactory {

    public static Lesson createLesson(String type, Dates startDates, Dates endDates, String subject) {
        Lesson lesson = null;
        if (type.toUpperCase().equals("TD")) {
            lesson = new TD(startDates, endDates, subject);
        } else if (type.toUpperCase().equals("TP")) {
            lesson = new TP(startDates, endDates, subject);
        } else if (type.toUpperCase().equals("CC")) {
            lesson = new CC(startDates, endDates, subject);
        }
        return lesson;
    }
}
