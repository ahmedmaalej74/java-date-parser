import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {
    public static List<Date> extractDates(String text) throws DateParserException {
        List<Date> dates = new ArrayList<Date>();
        dates.addAll(DateUtil.extractDates(text, "yyyy-MM-dd"));
        dates.addAll(DateUtil.extractDates(text, "dd MMMM yyyy"));
        dates.addAll(DateUtil.extractDates(text, "MMMM dd, yyyy"));
        return dates;
    }

    public static void showDates(List<Date> dates) throws DateParserException {
        if (dates == null) throw new DateParserException("The dates input is null");
        List<Date> sortedDates = DateUtil.sortDates(dates);
        Date previousDate = null;
        Date currentDate = null;
        int counter = 1;
        for (int i = 0; i < sortedDates.size(); i++) {
            currentDate = sortedDates.get(i);
            if (previousDate != null && previousDate.getDate() != currentDate.getDate()) {
                System.out.println("\t\t\t\t-" + (((previousDate.getDate() + 1) > 9) ? (previousDate.getDate() + 1) : "0" + (previousDate.getDate() + 1)) + " (" + counter + ")");
                counter = 1;
            }
            if (previousDate == null || previousDate.getYear() != currentDate.getYear())
                System.out.println((currentDate.getYear() + 1900) + ":");
            if (previousDate == null || previousDate.getMonth() != currentDate.getMonth())
                System.out.println("\t\t-" + (((currentDate.getMonth() + 1) > 9) ? (currentDate.getMonth() + 1) : "0" + (currentDate.getMonth() + 1)));
            if (previousDate != null && previousDate.getDate() == currentDate.getDate())
                counter++;
            previousDate = currentDate;
        }
        System.out.println("\t\t\t\t-" + (((previousDate.getDate() + 1) > 9) ? (previousDate.getDate() + 1) : "0" + (previousDate.getDate() + 1)) + " (" + counter + ")");
    }
}