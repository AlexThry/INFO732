import java.util.HashMap;
import java.util.Map;

public class Dates {
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;

    public Dates(int minute, int hour, int day, int month, int year) {
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Map<String, Integer> getDate() {
        Map<String, Integer> date = new HashMap<>();
        date.put("year", this.year);
        date.put("month", this.month);
        date.put("day", this.day);
        date.put("hour", this.hour);
        date.put("minute", this.minute);
        return date;
    }

    public String formatMonth(){
        if(month < 10){
            return "0" + month;
        }else {
            return "" + month;
        }
    }

    @Override
    public String toString() {
        return day + "/" + formatMonth() + "/" + year + ", " + hour + ":" + minute;
    }
}
