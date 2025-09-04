package leetcode;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class TestSimpleDateFormat {
public static void main(String[] args) {

    Timestamp ts = new Timestamp(1671042599000l);
    String pattern = "d/MMM/yyyy";
    Locale locale = new Locale("ar", "SA");
    TimeZone timeZone = TimeZone.getTimeZone("Asia/Calcutta");

    String formattedStr = getDisplayDate(ts, pattern, locale, timeZone);
    System.out.println("Formatted date : "+formattedStr);
}

    public static String getDisplayDate(final Timestamp ts, final String pattern, final Locale locale, final TimeZone timeZone) {
        String ret = null;
        if (ts == null)
            return "";

        final SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        formatter.setTimeZone(timeZone);
        ret = formatter.format(ts);

        return ret;
    }
}
