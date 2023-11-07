import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Date {
    private int minute;
    private int hour;
    private int day;
    private int mounth;
    private int year;

    public Date(int minute, int hour, int day, int mounth, int year) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }

    public Map<String, Integer> getDate() {
        Map<String, Integer> date = new HashMap<>();
        date.put("year", this.year);
        date.put("mounth", this.mounth);
        date.put("day", this.day);
        date.put("hour", this.hour);
        date.put("minute", this.minute);
        return date;
    }
}
