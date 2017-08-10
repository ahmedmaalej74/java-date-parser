import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            List<Date> dates = DateParser.extractDates("Marvin Lee Minsky at the Mathematics Genealogy Project; 20 May 2014\n" +
                    "Marvin Lee Minsky at the AI Genealogy Project. {reprint 18 September 2011)\n" +
                    "\"Personal page for Marvin Minsky\". web.media.mit.edu. Retrieved 23 June 2016.\n" +
                    "Admin (January 27, 2016). \"Official Alcor Statement Concerning Marvin Minsky\".\n" +
                    "Alcor Life Extension Foundation. Retrieved 2016-04-07.\n" +
                    "\"IEEE Computer Society Magazine Honors Artificial Intelligence Leaders\".\n" +
                    "DigitalJournal.com. August 24, 2011. Retrieved September 18, 2011.\n" +
                    "Press release source: PRWeb (Vocus).\n" +
                    "\"Dan David prize 2014 winners\". May 15, 2014. Retrieved May 20, 2014.");
            DateParser.showDates(dates);
        } catch (DateParserException e) {
            e.printStackTrace();
        }

    }
}