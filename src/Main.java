import java.time.DayOfWeek;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }

    static String getWorkingHours(Enum day){
        if (day == DayOfWeek.MONDAY)  return "200";
        if (day == DayOfWeek.TUESDAY)  return "160";
        if (day == DayOfWeek.WEDNESDAY)  return "120";
        if (day == DayOfWeek.THURSDAY)  return "80";
        if (day == DayOfWeek.FRIDAY)  return "40";
        if (day == DayOfWeek.SATURDAY)  return "Сегодня выходной";
        if (day == DayOfWeek.SUNDAY)  return "Сегодня выходной";
        else return null;
    }
}
