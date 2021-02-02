import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }

    static String getWorkingHours(Enum day){
        if (day == DayOfWeek.MONDAY)  return "40";
        if (day == DayOfWeek.TUESDAY)  return "32";
        if (day == DayOfWeek.WEDNESDAY)  return "24";
        if (day == DayOfWeek.THURSDAY)  return "16";
        if (day == DayOfWeek.FRIDAY)  return "8";
        if (day == DayOfWeek.SATURDAY)  return "Сегодня выходной";
        if (day == DayOfWeek.SUNDAY)  return "Сегодня выходной";
        else return null;
    }
}
