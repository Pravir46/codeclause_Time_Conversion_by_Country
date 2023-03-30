import java.text.SimpleDateFormat;
import java.util.*;

public class TimeZoneConverter {
    public static void main(String[] args) {
        String[] availableZoneIds = TimeZone.getAvailableIDs();
        System.out.println("Available time zones:");
        for (String zoneId : availableZoneIds) {
            System.out.println("  " + zoneId);
        }

        String format = "dd-M-yyyy hh:mm:ss a";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        Date localDate = new Date();
        TimeZone localTimeZone = TimeZone.getDefault();

        Calendar localCalendar = new GregorianCalendar();
        localCalendar.setTime(localDate);

        System.out.println("Local date and time: " + dateFormat.format(localCalendar.getTime()));
        System.out.println("Local time zone: " + localTimeZone.getID());
        System.out.println("Local time zone name: " + localTimeZone.getDisplayName());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the time zone to convert to (e.g. Europe/Paris): ");
        String targetTimeZoneId = scanner.next();

        TimeZone targetTimeZone = TimeZone.getTimeZone(targetTimeZoneId);
        SimpleDateFormat targetDateFormat = new SimpleDateFormat(format);
        targetDateFormat.setTimeZone(targetTimeZone);
        Calendar targetCalendar = new GregorianCalendar(targetTimeZone);

        targetCalendar.setTimeInMillis(localCalendar.getTimeInMillis());
        System.out.println("Date and time in " + targetTimeZone.getID() + ": " + targetDateFormat.format(targetCalendar.getTime()));
        System.out.println("Time zone name: " + targetTimeZone.getDisplayName());
    }
}
