public class UserFactory {

    public static User createUser(String type, String login, String password) {
        User user = null;
        if (type.toUpperCase().equals("A")) {
            user = new Admin(login, password);
        } else if (type.toUpperCase().equals("S")) {
            user = new Student(login, password);
        }

        return user;
    }
}
