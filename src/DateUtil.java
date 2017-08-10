import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
    private static final List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    private static final List<String> formats = Arrays.asList("yyyy-MM-dd", "dd MMMM yyyy", "MMMM dd, yyyy");

    public static Date parseDate(String date, String dateFormat) throws ParseException {
        return new SimpleDateFormat(dateFormat, Locale.US).parse(date);
    }

    public static List<Date> extractDates(String text, String dateFormat) throws DateParserException {
        if (!formats.contains(dateFormat))
            throw new DateParserException("The input format of the date is not supported!");
        String regex = null;
        Pattern pattern;
        Matcher matcher;
        List<Date> dates = new ArrayList<Date>();
        if (dateFormat.equals("yyyy-MM-dd")) {
            regex = "\\d{4}-\\d{2}-\\d{2}";
        } else if (dateFormat.equals("dd MMMM yyyy")) {
            regex = "\\d{2} (" + String.join("|", months) + ") \\d{4}";
        } else if (dateFormat.equals("MMMM dd, yyyy")) {
            regex = "(" + String.join("|", months) + ") \\d{2}, \\d{4}";
        }
        if (regex != null) {
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(text);
            while (matcher.find()) {
                try {
                    dates.add(DateUtil.parseDate(matcher.group(), dateFormat));
                } catch (ParseException e) {
                    System.err.println("Error occured while trying to parse the date `" + matcher.group() + "`");
                }
            }
        }
        return dates;
    }

    public static List<Date> sortDates(List<Date> dates) {
        List<Date> res = dates;
        Collections.sort(res, new Comparator<Date>() {
            @Override
            public int compare(Date date1, Date date2) {
                if (date1.getTime() < date2.getTime())
                    return -1;
                else if (date1.getTime() == date2.getTime())
                    return 0;
                else
                    return 1;
            }
        });
        return res;
    }
}