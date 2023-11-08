import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static User currentUser = null;
    static String currentUserStatus = null;
    static boolean quit = false;
    static ArrayList<Modules> modules = new ArrayList<>();


    public static String consoleEntry(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static boolean connect(ArrayList<User> users, String login, String password) {
        for (User user: users) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    if (currentUser instanceof Admin) {
                        currentUserStatus = "A";
                    } else {
                        currentUserStatus = "S";
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static void dashboard(User user, String userStatus) {
        System.out.println("Bienvenue " + user.getLogin() + " !");
        System.out.println("Que souhaitez vous faire ?");
        if (userStatus.equals("A")) {
            String option = consoleEntry("1. Créer un module \n2. Ajouter une lesson à un module \n3. Ajouter un devoir \n4. Quitter");
            switch (option) {
                case "1":
                    System.out.println("Création de module");
                case "2":
                    System.out.println("Ajout de module");
                case "3":
                    System.out.println("Ajout de devoir");
                case "4":
                    quit = true;
            }
        } else if (userStatus.equals("S")) {
            String option = consoleEntry("1. Voir les prochaines lessons \n2. Quitter");
            switch (option) {
                case "1":
                    for(Modules module : modules){
                        if(module.getStudentsLogin().contains(currentUser.getLogin())){
                            System.out.println(module.toString());
                        }
                    }
                case "2":
                    quit = true;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Student("john", "mdp"));
        modules.add(new Modules("INFO732", 1));
        modules.add(new Modules("MATH501", 2));
        modules.add(new Modules("INFO731", 3));

        modules.get(0).addStudents(users.get(0));
        modules.get(1).addStudents(users.get(0));

        Lesson lesson1 = LessonFactory.createLesson("TD",
                new Date(30, 8, 17, 11, 2023),
                new Date(0, 10, 17, 11, 2023),
                "modélisation");

        Lesson lesson2 = LessonFactory.createLesson("CC",
                new Date(30, 8, 18, 11, 2023),
                new Date(0, 10, 18, 11, 2023),
                "modélisation");

        Lesson lesson3 = LessonFactory.createLesson("TP",
                new Date(30, 8, 19, 11, 2023),
                new Date(0, 10, 19, 11, 2023),
                "proba");

        modules.get(1).addLesson(lesson3);
        modules.get(1).addLesson(lesson1);
        modules.get(0).addLesson(lesson2);

        while (!(quit)) {
            System.out.println("Bienvenu sur votre dashboard !");
            String haveAccount = consoleEntry("Avez vous un compte ? Y/n");
            if (haveAccount.toUpperCase().equals("N")) {
                String status = consoleEntry("Selectionnez votre situation : Admin (A) / Student (S)");
                if (status.equals("A") || status.equals("S")) {
                    String login = consoleEntry("Entrez votre login : ");
                    String password = consoleEntry("Entrez votre mot de passe : ");
                    try {
                        User user = UserFactory.createUser(status, login, password);
                        users.add(user);
                        System.out.println("Votre compte à été crée ! Veuillez vous connecter.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Veuillez entrer une valeur correcte");
                }


            } else if (haveAccount.toUpperCase().equals("Y")) {
                String login = consoleEntry("Veuillez entrer votre login : ");
                String password = consoleEntry("Veuillez entrer votre mot de passe : ");
                if (connect(users, login, password)) {
                    while (!quit) {
                        dashboard(currentUser, currentUserStatus);
                    }








                } else {
                    System.out.println("Identifiant ou mot de passe incorrect");
                }
            } else {
                System.out.println("Veuillez entrer une valeur correcte");
            }

        }




    }
}