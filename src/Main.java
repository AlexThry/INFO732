import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String consoleEntry(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void main(String[] args) {

        boolean quit = false;
        ArrayList<User> users = new ArrayList<>();

        while (!(quit)) {
            System.out.println("Bienvenu sur votre dashboard !");
            String haveAccount = consoleEntry("Avez vous un compte ? Y/n");
            if (haveAccount.toUpperCase().equals("N")) {
                String value = consoleEntry("Selectionnez votre situation : Admin (A) / Student (S)");
                String login = consoleEntry("Entrez votre login : ");
                String password = consoleEntry("Entrez votre mot de passe : ");
                try {
                    User user = UserFactory.createUser(value, login, password);
                    users.add(user);
                    System.out.println("Votre compte à été crée ! Veuillez vous connecter.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            } else if (haveAccount.toUpperCase().equals("Y")) {
                String login = consoleEntry("Veuillez entrer votre login : ");
                String password = consoleEntry("Veuillez entrer votre mot de passe : ");
                for (User user: users) {
                    if (user.getLogin().equals(login)) {
                        if (user.getPassword().equals(password)) {
                            System.out.println("Connecté");
                        }
                    }
                    System.out.println("Nom d'utilisateur ou mot de passe incorrect");
                }
            }
        }




    }
}