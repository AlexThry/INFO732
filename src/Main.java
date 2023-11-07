import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static User currentUser = null;
    static String currentUserStatus = null;
    static boolean quit = false;


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
                    System.out.println("Lessons");
                case "2":
                    quit = true;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

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