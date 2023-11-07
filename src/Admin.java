import java.util.ArrayList;

public class Admin extends User {
    private ArrayList<ChangeListener> changeListeners = new ArrayList<>();

    public Admin(String login, String password) {
        super(login, password);
        this.changeListeners = changeListeners;
    }

    @Override
    public void update() {

    }
}
